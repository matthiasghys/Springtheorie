package be.vdab.luigi.restclients;

import be.vdab.luigi.exceptions.KoersClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
@Component
public class FixerKoersClient implements KoersClient {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    private final URL url;

    FixerKoersClient(){
        try{
            url = new URL( "http://data.fixer.io/api/latest?access_key=db287c52d65147609fb1fb6acfe5740b&symbols=USD");
        }catch(MalformedURLException ex){
            String fout = "Fixer URL is verkeerd";
            logger.error(fout,ex);
            throw new KoersClientException(fout);
        }
    }


    @Override
    public BigDecimal getDollarKoers() {
        try(Scanner scanner = new Scanner(url.openStream())){
            String lijn = scanner.nextLine();
            int beginPositieKoers = lijn.indexOf("USD") + 5;
            int accoladePositite = lijn.indexOf('}',beginPositieKoers);
            return new BigDecimal(lijn.substring(beginPositieKoers,accoladePositite));
        } catch (IOException| NumberFormatException ex) {
           String fout = "kan koers niet lezen via fixer";
           logger.error(fout,ex);
           throw new KoersClientException(fout);
        }
    }
}
