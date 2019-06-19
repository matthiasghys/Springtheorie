package be.vdab.luigi.restclients;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Import(ECBKoersClient.class)
@PropertySource("application.properties")
public class ECBKoersClientTest {
    @Autowired
    private ECBKoersClient client;
    

    @Test
    public void deKoersMoetPositiefZijn(){
        Assertions.assertThat(client.getDollarKoers()).isPositive();

    }
}
