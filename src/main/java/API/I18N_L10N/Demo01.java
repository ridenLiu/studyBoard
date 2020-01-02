package API.I18N_L10N;

import org.junit.Test;

import java.util.Locale;

public class Demo01 {

    public static void main(String[] args) {
        localeList();
    }
    /**
     * java的本地化和国际化
     *
     */
    public static void localeList(){
        Locale[] localeList = Locale.getAvailableLocales();
        for (int i = 0; i < localeList.length; i++) {
            Locale lc = localeList[i];
            System.out.println(lc.getDisplayCountry()+" = "+lc.getCountry() + " "+lc.getDisplayLanguage()+" = "+lc.getLanguage());
        }
    }
}
