package tws.org.in.Quiz.App.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tws.org.in.Quiz.App.Dao.QuestionDAO;
import tws.org.in.Quiz.App.Question;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;
    public List<Question> getAllQuestions() {
        return questionDAO.findAll();
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionDAO.findByCategory(category);
    }


    public Question addQuestion(Question question) {
        return questionDAO.save(question);
    }

    public Question updateQuestion(Question question) {
        return questionDAO.save(question);
    }

    public void deleteQuestion(Question question) {
        questionDAO.delete(question);
    }

    public void deleteQuestionById(Integer id) {
        questionDAO.deleteById(id);
    }
}
