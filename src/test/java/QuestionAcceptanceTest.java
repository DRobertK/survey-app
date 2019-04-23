import com.robert.question.Question;
import com.robert.question.QuestionService;
import com.robert.survey.Survey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class QuestionAcceptanceTest {

    @Mock
    private QuestionService questionService;

    @Test
    public void givenQuestion_whenAdd_shouldHaveQuestionInSurvey() {
        Question question = new Question();
        Survey survey = new Survey();

//        questionService.add(question);

        assertThat(survey.getQuestions()).contains(question);
    }
}
