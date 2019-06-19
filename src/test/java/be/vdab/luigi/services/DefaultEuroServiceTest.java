package be.vdab.luigi.services;

import be.vdab.luigi.restclients.KoersClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class DefaultEuroServiceTest {
    @Mock
    private KoersClient koersClient;
    private DefaultEuroService defaultEuroService;

    @Before
    public void before(){
        when(koersClient.getDollarKoers()).thenReturn(BigDecimal.valueOf(1.5));
        defaultEuroService = new DefaultEuroService(new KoersClient[] {koersClient});
    }

    @Test
    public void naarDollar(){
        assertThat(defaultEuroService.naarDollar(BigDecimal.valueOf(2))).isEqualByComparingTo("3");
        verify(koersClient).getDollarKoers();
    }
}
