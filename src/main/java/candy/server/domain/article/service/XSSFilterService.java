package candy.server.domain.article.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Safelist;
import org.springframework.stereotype.Service;

@Service
public class XSSFilterService {

    public String makeSafeDocument(String html) {
        return Jsoup.clean(html, Safelist.relaxed().preserveRelativeLinks(true));
    }
}
