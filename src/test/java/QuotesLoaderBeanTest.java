/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import de.hspf.schuster.rs.jax.example.Citation;
import de.hspf.schuster.rs.jax.example.QuotesLoaderBean;
import java.util.Properties;
import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Marcel
 */
public class QuotesLoaderBeanTest {
    private QuotesLoaderBean quotesLoaderBean;
    
    public QuotesLoaderBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        quotesLoaderBean = new QuotesLoaderBean();
        quotesLoaderBean.init();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void whenCreateCitation_thenCitationShouldNotBeNull() {
       Citation citationLoaded = quotesLoaderBean.createCitation("");
        
       assertNotNull("Citation should not be null", citationLoaded);
    }
    
    @Test
    public void whenCreateCitationWithQuote_thenCitationShouldHaveQuote() {
        Citation citation = mock(Citation.class);
        Citation citationLoaded = quotesLoaderBean.createCitation("This is just a test quote");
        when(citation.getQuote()).thenReturn("This is just a test quote");
        
        assertEquals("Citations should contain the same quote", citationLoaded.getQuote(), citation.getQuote());
    }
    
    @Test
    public void whenCreateCitation_thenCitationShouldBeReturned() {
        Citation citationLoaded = quotesLoaderBean.createCitation("This is just a test quote");
        
        assertTrue(Citation.class.isInstance(citationLoaded));
    }
    
    @Test
    public void whenGetQuote_thenQuoteShouldNotBeNull() {
        Properties quotes = mock(Properties.class);
        when(quotes.getProperty(isA(String.class))).thenReturn("This is a citation");
        
        String quote = quotesLoaderBean.getQuote();
        
        assertNotNull("Quote string should not be null", quote);
    }
    
    @Test
    public void whenGetQuote_thenQuoteLengthShouldBeGreaterThanOne() {
        String quote = quotesLoaderBean.getQuote();
        Properties quotes = mock(Properties.class);
        when(quotes.getProperty("1")).thenReturn(quote);
        
        assertTrue(quote.length() > 0);
    }
    
    @Test
    public void whenGetQuote_thenQuoteShouldBeString() {
        String quote = quotesLoaderBean.getQuote();
        Properties quotes = mock(Properties.class);
        when(quotes.getProperty(isA(String.class))).thenReturn(quote);
        
        assertTrue(String.class.isInstance(quote));
    }
    
    @Test
    public void whenGetName_thenStringShouldBeReturned() {
        String name = quotesLoaderBean.getName();
        Properties names = createNiceMock(Properties.class);
        expect(names.getProperty(anyString())).andReturn(name);
        
        assertTrue(String.class.isInstance(name));
    }
    
    @Test
    public void whenGetName_thenNameShouldNotBeEmpty() {
        String name = quotesLoaderBean.getName();
        Properties names = createNiceMock(Properties.class);
        expect(names.getProperty(anyString())).andReturn(name);
        
        assertTrue(name.length() > 0);
        assertNotNull(name);
    }
}