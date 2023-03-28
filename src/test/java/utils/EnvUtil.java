package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvUtil {

    public static String getFromEnv( String sendText){

    Dotenv dotenv = Dotenv.configure()
                .filename("datas.env")
                .ignoreIfMissing()
                .ignoreIfMalformed()
                .load();

     return dotenv.get(sendText);
    }
}
