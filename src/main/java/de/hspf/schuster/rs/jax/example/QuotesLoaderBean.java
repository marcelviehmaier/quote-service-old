package de.hspf.schuster.rs.jax.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 *
 * @author thomas.schuster
 */
@Singleton
public class QuotesLoaderBean {

    Properties quotes;
    Properties names;

    @PostConstruct
    public void init() {
        InputStream quotesInput = this.getClass().getClassLoader().getResourceAsStream("quotes.properties");
        InputStream namesInput = this.getClass().getClassLoader().getResourceAsStream("names.properties");

        quotes = new Properties();
        names = new Properties();
        try {
            quotes.load(quotesInput);
            names.load(namesInput);
        } catch (IOException ex) {
            Logger.getLogger(QuotesLoaderBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Citation createCitation(String quote) {
        Citation citation = new Citation();
        citation.setQuote(quote);
        citation.setWho(getName());
        return citation;
    }

    public Citation getCitation() {
        Citation citation = new Citation();
        citation.setQuote(getQuote());
        citation.setWho(getName());
        return citation;
    }
    
    public String getQuote() {
        Enumeration keys = quotes.propertyNames();
        int elementNumber = new Random().nextInt(quotes.keySet().size());
        return quotes.getProperty(getElement(keys, elementNumber));
    }

    public String getName() {
        Enumeration keys = names.propertyNames();
        int elementNumber = new Random().nextInt(names.keySet().size());
        return names.getProperty(getElement(keys, elementNumber));
    }

    private String getElement(Enumeration keys, int elementNumber) {
        int i = 0;
        while (keys.hasMoreElements()) {
            if (i == elementNumber) {
                return (String) keys.nextElement();
            } else {
                i++;
                keys.nextElement();
            }
        }
        return null;
    }
}
