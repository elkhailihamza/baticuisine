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

    public void registerNewQuote(Projets projet) {
        List<LocalDate> dates = QuoteView.registerQuotes();
        double montantEstime = projet.getCoutTotal() * (1 + projet.getMargeBeneficiaire());
        Quotes quote = new Quotes(1, montantEstime, dates.getFirst(), dates.getLast(), false, projet.getProjet_id());
        this.quoteService.save(quote);
        QuoteView.saveSuccessful();
    }
}
