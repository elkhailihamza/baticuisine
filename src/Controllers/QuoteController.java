package Controllers;

import Models.Projets;
import Models.Quotes;
import Services.QuoteService;
import Views.QuoteView.QuoteView;

import java.time.LocalDate;
import java.util.List;

public class QuoteController extends Controller{
    private final QuoteService quoteService;
    public QuoteController() {
        super();
        this.quoteService = repository.getQuoteService();
    }

    public Quotes createNewQuote(Projets projet) {
        List<LocalDate> dates = QuoteView.registerQuotes();
        double montantEstime = Math.round(projet.getCoutTotal() * (1 + projet.getMargeBeneficiaire()));
        return new Quotes(1, montantEstime, dates.getFirst(), dates.getLast(), false, projet.getProjet_id());
    }

    public void saveQuote(Quotes quote) {
        this.quoteService.save(quote);
    }
}
