package hobby.internetms52.robotxtgen.text_gen;

import java.util.List;

public class SitemapTextGenerator implements TextGen<List<String>> {

    @Override
    public String gen(List<String> sitemaps) {
        StringBuilder stringBuilder = new StringBuilder();
        sitemaps.forEach(sitemap -> {
            stringBuilder.append(keyValuePairGenText(RobotTextFields.Sitemap.value, sitemap));
        });
        return stringBuilder.toString();
    }
}
