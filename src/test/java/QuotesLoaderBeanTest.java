/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import de.hspf.schuster.rs.jax.example.Citation;
import de.hspf.schuster.rs.jax.example.QuotesLoaderBean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
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
}