import com.casper.sdk.CasperSdk;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountBalance {

    public static final Logger LOGGER = Logger.getLogger(AccountBalance.class.getName());

    public static final String ACCOUNT_KEY = "01cb99ab80325d73552c7c0b8d10d8cb2d19116b1f233431751fe82f9c25db51c1";

    public static String prettyPrintJson(String jsonString) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Object object = objectMapper.readValue(jsonString, Object.class);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }

    public static void main(String[] args) {

        CasperSdk casperSdk = new CasperSdk("http://3.136.227.9", 7777);

        try {

            String accountBalance = casperSdk.getAccountBalance(ACCOUNT_KEY);
            LOGGER.log(Level.INFO, "Account Balance for Account " + ACCOUNT_KEY + " is: " + accountBalance);
        } catch ( Throwable exp ){
            LOGGER.log(Level.SEVERE, "Exception while fetching account balance", exp);
        }
    }

}
