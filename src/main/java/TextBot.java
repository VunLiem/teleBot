import DAO.SaleTransDAO;
import config.TelebotConfig;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TextBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && !update.getMessage().getText().isEmpty()) {
            String command = update.getMessage().getText();
            String chat_id = update.getMessage().getChatId().toString();
            if (command.equals("/start")
                    || command.equals("/home")
                    || command.equals("/report")) {

                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Click the button below to choose our services!");
                sendMessage.setChatId(chat_id);
                sendMessage.setParseMode(ParseMode.MARKDOWN);

                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

                List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();
                List<InlineKeyboardButton> Button1 = new ArrayList<>();
                List<InlineKeyboardButton> Button2 = new ArrayList<>();
                List<InlineKeyboardButton> Button3 = new ArrayList<>();
                InlineKeyboardButton M1 = new InlineKeyboardButton();
                InlineKeyboardButton M2 = new InlineKeyboardButton();
                InlineKeyboardButton M3 = new InlineKeyboardButton();

                M1.setText("Amount not tax report");
                M2.setText("Amount tax report");
                M3.setText("Metfone Internet Plans");

                M1.setCallbackData("button1");
                M2.setCallbackData("button2");
                M3.setCallbackData("button3");
                Button1.add(M1);
                Button2.add(M2);
                Button3.add(M3);
                listInlineButton.add(Button1);
                listInlineButton.add(Button2);
                listInlineButton.add(Button3);

                inlineKeyboardMarkup.setKeyboard(listInlineButton);
                sendMessage.setReplyMarkup(inlineKeyboardMarkup);

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (command.equals("/help")
                    || command.equals("Help")
                    || command.equals("help")) {
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("To get automatically report, please use these commands /start or /report or /home " +
                        "and to get photo from local path, please use these commands /picture or /photo");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (command.equals("Hi")
                    || command.equals("Hello")) {
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("Hi dear! I am bot! For more details about the bot option " +
                        "please go to help center by use this command /help");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (command.equals("Connect to admin")
                    || command.equals("admin")) {
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("Connecting... please wait!!!");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }else if (command.equals("/picture")||command.equals("/photo")){
                SendPhoto smg = new SendPhoto();
                smg.setChatId(chat_id);

                File imageFile = new File("E:\\Photo\\car.jpg");

                smg.setCaption("Here is the photo from local file");
                smg.setPhoto(new InputFile(imageFile));

                try {
                    execute(smg); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("Our apologies, support via chat is not available at the moment. " +
                        "Please go to help center by using command /help");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
        else if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            String chat_id = callbackQuery.getFrom().getId().toString();

            SendChatAction sendChatAction = new SendChatAction();
            if (data.equals("button1")) {
                sendChatAction.setChatId(chat_id);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Generating report, please wait!");
                sendMessage.setChatId(chat_id);
                try {
                    sendChatAction.setAction(ActionType.TYPING);
                    execute(sendChatAction);
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                // send photo from FILE path local
                SendPhoto message = new SendPhoto();
                message.setChatId(chat_id);
                String imgName = null;
                try {
                    imgName = ChartReportofNottax();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                message.setCaption("Here is amount not tax report");
                message.setPhoto(new InputFile(new File(imgName)));

                try {
                    execute(message); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (data.equals("button2")) {
                sendChatAction.setChatId(chat_id);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Generating report, please wait!");
                sendMessage.setChatId(chat_id);
                try {
                    sendChatAction.setAction(ActionType.TYPING);
                    execute(sendChatAction);
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                // send photo from FILE path local
                SendPhoto message = new SendPhoto();
                message.setChatId(chat_id);
                String imgName = null;
                try {
                    imgName = ChartReportoftax();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                message.setCaption("Here is amount tax Report");
                message.setPhoto(new InputFile(new File(imgName)));
                try {
                    execute(message); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
            else if (data.equals("button3")) {
                sendChatAction.setChatId(chat_id);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Generating Metfone MIU plan");
                sendMessage.setChatId(chat_id);
                try {
                    sendChatAction.setAction(ActionType.TYPING);
                    execute(sendChatAction);
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                SendPhoto smg = new SendPhoto();
                smg.setChatId(chat_id);

                File imageFile = new File("E:\\Photo\\Metfone MIU plan.png");

                smg.setCaption("Here is metfone MIU plan");
                smg.setPhoto(new InputFile(imageFile));

                try {
                    execute(smg); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static String ChartReportofNottax() throws IOException {
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Report of amount not tax",
                "Sale date", "Amount not tax",
                createDataset1(), PlotOrientation.VERTICAL.VERTICAL,
                true, true, false);

        int width = 640;
        int height = 480;

        SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        String date = simpleFormatter.format(new Date());
        String fileName = "ChartReportoftax_" + date + ".jpeg";
        File ChartReport = new File(fileName);
        ChartUtilities.saveChartAsJPEG( ChartReport , lineChart , width , height );
        return ChartReport.getAbsolutePath();
    }

    private static DefaultCategoryDataset createDataset1() {
        try{

            DefaultCategoryDataset dataset1 = new DefaultCategoryDataset( );
            dataset1 = SaleTransDAO.getALlSaleTrans1(dataset1);

            return dataset1;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static String ChartReportoftax() throws IOException {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Report of amount tax",
                "Sale date", "Amount tax",
                createDataset2(), PlotOrientation.VERTICAL.VERTICAL,
                true, true, false);

        int width = 680;
        int height = 500;

        SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        String date = simpleFormatter.format(new Date());
        String fileName = "ChartReportofnottax_" + date + ".jpeg";
        File ChartReport = new File(fileName);
        ChartUtilities.saveChartAsJPEG( ChartReport , barChart , width , height );
        return ChartReport.getAbsolutePath();
    }
    private static DefaultCategoryDataset createDataset2() {
        try{

            DefaultCategoryDataset dataset2 = new DefaultCategoryDataset( );
            dataset2 = SaleTransDAO.getALlSaleTrans2(dataset2);

            return dataset2;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String getBotUsername() {
        return TelebotConfig.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return TelebotConfig.BOT_TOKEN;
    }
}

