package springFox;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import io.swagger.annotations.ApiOperation;

@Configuration
@EnableSwagger2  // Annotation to enable Springfox usage
public class AppConfig {
    @Bean
    public Docket document() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("sample-api")	// Identification to group API document
                .select()
                .paths(paths())
                .build()
                .apiInfo(apiInfo());
    }
    private Predicate<String> paths() {
    	// Specify API URL which is the target for document creation
    	// In this case, "/user" is
        return Predicates.or(Predicates.containsPattern("/user"));
    }
    // APIの基本情報を定義
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Sample API"  // APIのタイトル
              , "このAPIは～～～～です"  // APIの説明
              , "V1"  // APIのバージョン
              , "????"    // よくわからない
              , new Contact(
                       "株式会社XXXXXXX"      // APIに関する連絡先組織・団体等
                      ,"http://XXXXXXXXXXX.co.jp" // APIに関する連絡先組織・団体等のWeb Site Url
                      ,"XXXXXXXX@example.jp")     // APIに関する連絡先組織・団体等のメールアドレス
              , "API LICENSE" // APIのライセンス
              , "http://XXXXXXXXXXXX.co.jp"   // APIのライセンスURL
              , new ArrayList<VendorExtension>()  // 独自に拡張したいドキュメントがあればここで作成
        );
    }
}
