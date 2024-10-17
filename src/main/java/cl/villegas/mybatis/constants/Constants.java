package cl.villegas.mybatis.constants;

import javax.mail.Authenticator;

public class Constants {

    public static final class App {
        public static final String NAME = "Spring Framework MyBatis";
    }

    public static final class Boolean {
        public static final String TRUE = "TRUE";
        public static final String FALSE = "FALSE";
    }

    public static final class ContentType {
        public static final String APPLICATION_EXCEL = "application/vnd.ms-excel";
        public static final String APPLICATION_PDF = "application/pdf";
        public static final String TEXT_CSV = "text/csv";
        public static final String TEXT_HTML = "text/html";
    }

    public static final class CorsConfiguration {
        public static final boolean ALLOW_CREDENTIALS = true;
        public static final String ALLOWED_ORIGIN = "*";
        public static final String ALLOWED_HEADER = "*";
        public static final String ALLOWED_METHOD = "*";
    }

    public static final class CorsConfigurationSource {
        public static final String PATH = "/**";
    }

    public static final class DataSource {
        public static final boolean GENERATE_UNIQUE_NAME = false;
        public static final String NAME = "testdb";
        public static final String SCRIPT_ENCODING = "UTF-8";
        public static final boolean IGNORE_FAILED_DROPS = true;
    }

    public static final class FileExtension {
        public static final String XLSX = ".xlsx";
        public static final String PDF = ".pdf";
        public static final String CSV = ".csv";
        public static final String HTML = ".html";
        public static final String JRXML = ".jrxml";
    }

    public static final class FileType {
        public static final String XLSX = "XLSX";
        public static final String PDF = "PDF";
        public static final String CSV = "CSV";
        public static final String HTML = "HTML";
    }

    public static final class FreeMarkerConfigurer {
        public static final String TEMPLATE_LOADER_PATH = "classpath:/templates/";
        public static final String ENCODING = "utf-8";
    }

    public static final class H2 {
        public static final String CONTEXT_ROOT_PATH = "h2-console";
        public static final String MAPPING = "/h2-console/*";
    }

    public static final class HttpHeaders  {
        public static final String CONTENT_DISPOSITION_PROPERTY = "content-disposition";
        public static final String INLINE_FILENAME_PROPERTY = "inline; filename=";
    }

    public static final class MimeMessage {
        public static final String CONTENT_TYPE_HEADER_PROPERTY = "Content-type";
        public static final String CONTENT_TYPE_HEADER_VALUE = "text/HTML; charset=UTF-8";
        public static final String FORMAT_HEADER_PROPERTY = "format";
        public static final String FORMAT_HEADER_VALUE = "flowed";
        public static final String CONTENT_TRANSFER_ENCODING_HEADER_PROPERTY = "Content-Transfer-Encoding";
        public static final String CONTENT_TRANSFER_ENCODING_HEADER_VALUE = "8bit";
        public static final String FROM_EMAIL = "noreply@villegas.cl";
        public static final String FROM_EMAIL_NAME = "Noreply Villegas";
        public static final String SUBTYPE = "html";
        public static final boolean STRICT = false;
        public static final String CHARSET = "UTF-8";
    }

    public static final class MultiPartResolver {
        private static final int ONE_MEGA_BYTES = 1024;
        public static final int MAX_UPLOAD_SIZE = 5 * ONE_MEGA_BYTES * ONE_MEGA_BYTES; // 5 MB
    }

    public static final class MyBatis {
        public static final String TYPE_ALIASES_PACKAGE = "cl.villegas.mybatis.model";
        public static final String TYPE_HANDLERS_PACKAGE = "cl.villegas.mybatis.typehandler";
    }

    public static final class Properties {
        public static final String MAIL_SMTP_HOST_PROPERTY = "mail.smtp.host";
        public static final String MAIL_SMTP_HOST_VALUE = "1.0.0.0";
    }

    public static final class Report {
        public static final String PATH = "/reports/";
    }

    public static final class Resolver {
        public static final String PREFIX = "/WEB-INF/views/";
        public static final String SUFFIX = ".jsp";
    }

    public static final class Session {
        public static final Authenticator AUTHENTICATOR = null;
    }

    public static final class Spring {
        public static final String PROFILE_PROPERTY = "spring.profiles.active";
        public static final String DEFAULT_PROFILE = "default";
    }

    public static final class Swagger {
        public static final String PACKAGE = "cl.villegas.mybatis.controller";
        public static final String TITLE = "SPRING FRAMEWORK MYBATIS REST API";
        public static final String DESCRIPTION = "Spring Framework MyBatis API";
        public static final String NAME = "Byron Stevens Villegas Moya";
        public static final String URL = "https://gitlab.com/users/byron.villegas/projects";
        public static final String EMAIL = "byronvillegasm@gmail.com";
        public static final String LICENSE = "Apache 2.0";
        public static final String LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0.html";
        public static final String LICENSE_VERSION = "1.0.0";
        public static final String PAGE = "swagger-ui.html";
        public static final String RESOURCES_PATH = "classpath:/META-INF/resources/";
    }

    public static final class ValueType {
        public static final String BO = "BO";
        public static final String BY = "BY";
        public static final String CH = "CH";
        public static final String SH = "SH";
        public static final String IN = "IN";
        public static final String LO = "LO";
        public static final String FL = "FL";
        public static final String DO = "DO";
        public static final String ST = "ST";
    }

    public static final class Web {
        public static final String JAR_PATH = "/webjars/**";
        public static final String JAR_RESOURCES_PATH = "classpath:/META-INF/resources/webjars/";
    }
}