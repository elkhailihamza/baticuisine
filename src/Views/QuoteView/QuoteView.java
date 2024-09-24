package Views.QuoteView;

import Models.Projets;
import Models.Quotes;
import Tools.GetValue;
import Tools.TextStyles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QuoteView {
    public static List<LocalDate> registerQuotes() {
        List<LocalDate> dates;
        LocalDate startDate;
        LocalDate endDate;
        String pattern = "dd/MM/yyyy";
        TextStyles.header("--- Enregistrement du Devis ---");
        do {
            dates = new ArrayList<>();

            startDate = GetValue.localDateValue(new String[]{"Entrez la date d'émission du devis (format : jj/mm/aaaa) :"}, pattern);
            dates.add(startDate);

            endDate = GetValue.localDateValue(new String[]{"Entrez la date de validité du devis (format : jj/mm/aaaa) :"}, pattern);
            dates.add(endDate);
        } while (!GetValue.yOrNValue(new String[]{"Souhaitez-vous enregistrer le devis ? (y/n) : "}));
        TextStyles.header("Devis enregistré avec succès !");
        return dates;
    }

    public static void displayQuote(Quotes q, Projets p) {
        TextStyles.text("- Devis : "+q.getQuote_id()+". Nom : "+p.getNomProjet()+" | Montant estime : "+q.getMontantEstime()+" Date emission : "+q.getDateEmission()+" Date validate : "+q.getDateValidate()+". estAccepté : "+q.isAccepte());
    }

    public static boolean askForAccept() {
        return GetValue.yOrNValue(new String[]{"Souhaitez-vous accepter un devis ? (y/n) : "});
    }

    public static void quoteNotFound() {
        TextStyles.error("Devis non trouvé!");
    }
}
