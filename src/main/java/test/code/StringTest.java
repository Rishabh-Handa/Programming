package test.code;

public class StringTest {
    public static final String CMIS_PREFIX = "cmis:";
    public static final String CMIS_URL_PREFIX = "/jars/";
    public static void main(String[] args) {
        String location = "http://localhost:8082/ssc-engine/jars/htmlcomponent.jar";

        if (location.contains(CMIS_URL_PREFIX)) {
            String cmisLocation = CMIS_PREFIX + location.substring(location.indexOf(CMIS_URL_PREFIX));
            System.out.println(cmisLocation);
        }
    }
}
