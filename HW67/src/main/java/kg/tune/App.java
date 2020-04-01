package kg.tune;

import kg.tune.entities.Championship;
import kg.tune.entities.Country;
import kg.tune.entities.Sport;
import kg.tune.entities.Team;
import kg.tune.util.HibernateUtil;
import org.hibernate.Session;

public class App {
    public static void main( String[] args ) {
        Country eng = new Country("England"); Country prg = new Country("Portugal");
        Country rus = new Country("Russia"); Country esp = new Country("Spain");
        Country usa = new Country("United States of America"); Country fra = new Country("France");

        Sport football = new Sport("football"); Sport tennis = new Sport("tennis");
        Sport basketball = new Sport("basketball"); Sport baseball = new Sport("baseball");

        Championship laliga = new Championship("La-Liga", esp, football);
        Championship sbl = new Championship("Super Basketball League", usa, basketball);
        Championship mlb = new Championship("Major League Baseball", usa, baseball);
        Championship iptl = new Championship("Rolland Garros", fra, tennis);
        Championship nos = new Championship("Liga NOS", prg, football);
        Championship seriaA = new Championship("Seria A", fra, football);
        Championship VTB = new Championship("Единая Лига ВТБ", rus, basketball);
        Championship apl = new Championship("English Premier League", eng, football);

        Team rma = new Team("Real Madrid", "C:\\Users\\User\\Desktop\\test\\rma-logo.png", "realmadrid.com", football);
        Team mu = new Team("Manchester United", "C:\\Users\\User\\Desktop\\test\\mu-logo.png", "manutd.com", football);
        Team hawks = new Team("Hawks", "C:\\Users\\User\\Desktop\\test\\hawks-logo.png", "hawks.com", basketball);
        Team rlg = new Team("Rolland Garros", "C:\\Users\\User\\Desktop\\test\\rlg-logo.png", "rollandgarros.com", tennis);

        //creating countries
        create(eng); create(rus); create(usa); create(prg); create(esp); create(fra);
        //creating sports
        create(football); create(baseball); create(basketball); create(tennis);
        //creating championships
        create(laliga); create(sbl); create(mlb); create(iptl); create(nos); create(seriaA); create(VTB); create(apl);
        //creating TEAMS
        create(rma); create(mu); create(hawks); create(rlg);
    }

    public static <T> void create(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created!");
    }
}
