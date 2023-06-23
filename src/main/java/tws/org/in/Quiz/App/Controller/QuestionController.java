package tws.org.in.Quiz.App.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.org.in.Quiz.App.Question;
import tws.org.in.Quiz.App.Service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    // Listing out all the Questions from the Database
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    // Listing out the Questions by the Category
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    // Adding a Question into the Database
    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    // Updating Question

    @PutMapping("/update")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }

    // Deleting Question by Whole Json File
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteQuestion(@RequestBody Question question){
        return questionService.deleteQuestion(question);
    }

    // Deleting Question by ID
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestionByID(@PathVariable Integer id) {
        return questionService.deleteQuestionById(id);
    }
}
