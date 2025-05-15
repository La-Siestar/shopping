package search.infrastructure.config;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import co.elastic.clients.elasticsearch.core.InfoResponse;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestClient;
import org.springframework.boot.ApplicationRunner;

@Slf4j
@Configuration
public class ElasticsearchConfig {

    /** ES 노드 주소 · 포트 · 스킴을 하드코딩 */
    private static final HttpHost ES_HOST = new HttpHost("localhost", 9200, "http");
    /** 연결 타임아웃(ms) */
    private static final int CONNECT_TIMEOUT = 5_000;
    /** 소켓 타임아웃(ms) */
    private static final int SOCKET_TIMEOUT  = 5_000;

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        // 1) RestClient 빌더에 호스트·타임아웃 설정
        RestClientBuilder builder = RestClient.builder(ES_HOST)
                .setRequestConfigCallback(cfg -> cfg
                        .setConnectTimeout(CONNECT_TIMEOUT)
                        .setSocketTimeout(SOCKET_TIMEOUT)
                );

        RestClient restClient = builder.build();

        // 2) Java API Client 생성
        ElasticsearchClient client = new ElasticsearchClient(
                new RestClientTransport(restClient, new JacksonJsonpMapper())
        );

        // 3) 초기 헬스체크 (Info API) & 로깅
        try {
            InfoResponse info = client.info();
            log.info("✅ ES up: clusterName={}  clusterUuid={}  version={}",
                    info.clusterName(), info.clusterUuid(), info.version().number());
        } catch (Exception e) {
            log.error("❌ Elasticsearch init failed", e);
            throw new IllegalStateException("Failed to initialize ElasticsearchClient", e);
        }

        return client;
    }
    @Bean
    public ApplicationRunner esHealthRunner(ElasticsearchClient client) {
        return args -> {
            try {
                var health = client.cluster().health();
                log.info("ES health: {}", health.status());
            } catch (Exception e) {
                log.warn("ES health check failed, continuing startup", e);
            }
        };
    }

}
