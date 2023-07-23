package persistence;

import model.ListOfQuestions;
import model.Question;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JsonReader {
    private String source;


    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    public ListOfQuestions read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseListOfQuestions(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    private ListOfQuestions parseListOfQuestions(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        ListOfQuestions loq = new ListOfQuestions(name);
        addQuestions(loq, jsonObject);
        return loq;
    }



    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addQuestions(ListOfQuestions loq, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("questions");
        for (Object json : jsonArray) {
            JSONObject nextquestions = (JSONObject) json;
            addQuestion(loq, nextquestions);
        }

    }

    private void addQuestion(ListOfQuestions loq, JSONObject jsonObject) {
        String question = jsonObject.getString("question");
        String correctanswer = jsonObject.getString("correctanswer");
        int assignedpoints = jsonObject.getInt("assignedpoints");
        Question q = new Question(question, correctanswer, assignedpoints);
        loq.addQuestion(q);
    }


}
