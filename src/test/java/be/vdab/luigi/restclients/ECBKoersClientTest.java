package be.vdab.luigi.restclients;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ECBKoersClientTest {

    private ECBKoersClient client;
    @Before
    public void before(){
        client = new ECBKoersClient();
    }

    @Test
    public void deKoersMoetPositiefZijn(){
        Assertions.assertThat(client.getDollarKoers()).isPositive();

    }
}
