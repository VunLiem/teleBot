import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramBot;

public class teleBot extends TelegramLongPollingBot{
        @Override
        public void onUpdateReceived(Update update) {
            // TODO
            String command = update.getMessage().getText();
            if (command.equals("/run")){
                String msg = "Let run";
                SendMessage respone = new SendMessage();
                respone.setChatId(update.getMessage().getChatId().toString());
                respone.setText(msg);

                try {
                    execute(respone);

                }catch (TelegramApiException E){
                    E.printStackTrace();
                }
            }
        }

        @Override
        public String getBotUsername() {
            // TODO
            return "My12tele_Bot";
        }

        @Override
        public String getBotToken() {
            // TODO
            return "5210269411:AAEK2D4Tkqkh-Aoy3x63yjmrEt2BDP540rk";
        }
    }
