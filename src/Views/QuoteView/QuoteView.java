package Views.QuoteView;

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
}
