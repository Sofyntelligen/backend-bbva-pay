package com.bbva.shopping.pay.api;

import com.bbva.shopping.pay.api.model.dto.enums.TypeCards;
import com.bbva.shopping.pay.api.model.entity.Card;
import com.bbva.shopping.pay.api.model.entity.User;
import com.bbva.shopping.pay.api.model.entity.UserAccess;
import com.bbva.shopping.pay.api.repositories.CardRerpository;
import com.bbva.shopping.pay.api.repositories.UserAccessRepository;
import com.bbva.shopping.pay.api.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class Application {

    @Autowired
    private UserAccessRepository userAccessRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardRerpository cardRerpository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            
            User userOmar = new User("Omar", "Perez", 21, LocalDate.now(), "Av. principal No. 45", "omar@bbva.com", "2345678912", Boolean.TRUE);
            User userDaniel = new User("Daniel", "Jiminez", 22, LocalDate.now(), "Av. principal No. 45", "daniel@bbva.com", "5523983674", Boolean.TRUE);
            User userGabriela = new User("Gabriela", "Lopez", 23, LocalDate.now(), "Av. principal No. 45", "gabriela@bbva.com", "5692871298", Boolean.FALSE);
            User userHumberto = new User("Humberto", "Hernandez", 24, LocalDate.now(), "Av. principal No. 45", "humberto@bbva.com", "5564738291", Boolean.TRUE);
            User userPablo = new User("Pablo", "Salinas", 25, LocalDate.now(), "Av. principal No. 45", "pablo@bbva.com", "5683752926", Boolean.TRUE);

            this.userAccessRepository.save(new UserAccess("Omar", "87654321"));
            this.userAccessRepository.save(new UserAccess("Daniel", "asdfghjk"));
            this.userAccessRepository.save(new UserAccess("Gabriela", "19283746"));
            this.userAccessRepository.save(new UserAccess("Humberto", "aksjdhfg"));
            this.userAccessRepository.save(new UserAccess("Pablo", "wsxedcrf"));
            this.userRepository.save(userOmar);
            this.userRepository.save(userDaniel);
            this.userRepository.save(userGabriela);
            this.userRepository.save(userHumberto);
            this.userRepository.save(userPablo);
            this.cardRerpository.save(new Card("1234567809874532", LocalDate.now(), 234, new BigDecimal(21000.00), new BigDecimal(18000.00), new BigDecimal(3000.00), TypeCards.CARD_CREDITO, userOmar));
            this.cardRerpository.save(new Card("1234213124874532", LocalDate.now(), 765, new BigDecimal(21000.00), BigDecimal.ZERO, BigDecimal.ZERO, TypeCards.CARD_DEBITO, userOmar));
            this.cardRerpository.save(new Card("2342342345174532", LocalDate.now(), 154, new BigDecimal(100000.00), new BigDecimal(18000.00), new BigDecimal(82000.00), TypeCards.CARD_CREDITO, userDaniel));
            this.cardRerpository.save(new Card("6574957623462732", LocalDate.now(), 987, new BigDecimal(21000.00), new BigDecimal(18000.00), new BigDecimal(3000.00), TypeCards.CARD_CREDITO, userGabriela));
            this.cardRerpository.save(new Card("0983516277387823", LocalDate.now(), 613, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, TypeCards.CARD_DEBITO, userGabriela));
            this.cardRerpository.save(new Card("8375492178359871", LocalDate.now(), 487, new BigDecimal(35000.00), BigDecimal.ZERO, BigDecimal.ZERO, TypeCards.CARD_DEBITO, userGabriela));
            this.cardRerpository.save(new Card("1238728763467632", LocalDate.now(), 154, new BigDecimal(21000.00), new BigDecimal(18000.00), new BigDecimal(3000.00), TypeCards.CARD_CREDITO, userHumberto));
            this.cardRerpository.save(new Card("7652834587235710", LocalDate.now(), 825, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, TypeCards.CARD_DEBITO, userHumberto));
            this.cardRerpository.save(new Card("0029841863413642", LocalDate.now(), 935, new BigDecimal(1000.00), BigDecimal.ZERO, BigDecimal.ZERO, TypeCards.CARD_DEBITO, userPablo));
            
        };
    }
    
}
