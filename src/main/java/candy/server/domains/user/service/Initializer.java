package candy.server.domains.user.service;

import candy.server.session.Config;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class Initializer extends AbstractHttpSessionApplicationInitializer {

    public Initializer() {
        super(Config.class);
    }

}