package tws.org.in.Quiz.App.Controller;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    // Listing out the Questions by the Category
    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    // Adding a Question into the Database
    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    // Updating Question

    @PutMapping("/update")
    public Question updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }

    // Deleting Question by Whole Json File
    @DeleteMapping("/delete")
    public String deleteQuestion(@RequestBody Question question){
        questionService.deleteQuestion(question);
        return "Deleted Successfully";
    }

    // Deleting Question by ID
    @DeleteMapping("delete/{id}")
    public String deleteQuestionByID(@PathVariable Integer id) {
        questionService.deleteQuestionById(id);
        return "Deleted Successfully by ID";
    }

}
