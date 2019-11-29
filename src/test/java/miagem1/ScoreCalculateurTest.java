package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private QuestionAChoixMultiple uneQuestion;
    private List<Integer> indicesReponse;
    private List<Integer> indicesReponseEtudiant;
    private ScoreCalculateur calculateur ;
    private Float score ;

    @Before
    public void testSetUp() throws Exception {
        indicesReponse = new ArrayList<Integer>(Arrays.asList(2,3,5));
        uneQuestion = new QuestionAChoixMultiple("q1", indicesReponse);
        calculateur = new ScoreCalculateur();
    }

    @Test
    public void testCalculeScore() {
        indicesReponseEtudiant = new ArrayList<Integer>(Arrays.asList(1,4));
        score = calculateur.calculeScore(indicesReponseEtudiant, uneQuestion) ;
        assertEquals(new Float(0f), score);

        indicesReponseEtudiant = new ArrayList<Integer>(Arrays.asList(2,3));
        score = calculateur.calculeScore(indicesReponseEtudiant, uneQuestion) ;
        assertEquals(new Float(2*100f/3), score);

        indicesReponseEtudiant = new ArrayList<Integer>(Arrays.asList(2,3,5));
        score = calculateur.calculeScore(indicesReponseEtudiant, uneQuestion) ;
        assertEquals(new Float(100f), score);
    }
}