package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple uneQuestion;

    @Before
    public void testSetUp() throws Exception {
        // given : un objet de type QuestionAChoixExclusif
        uneQuestion = new QuestionAChoixMultiple("q1", new ArrayList<Integer>(Arrays.asList(2,3,5)));
    }

    @Test
    public void testGetEnonce() {
        // when : on demande l'énoncé à la question
        String resEnonce = uneQuestion.getEnonce();
        // then : l'énoncé est non null
        assertNotNull(resEnonce);
        //and : l'énoncé est bien celui fourni à la construction
        assertEquals(resEnonce, "q1");
    }

    @Test
    public void testGetScoreForIndice() {
        //when : un étudiant fourni l'indice correspondant à la bonne réponse
        int indiceEtudiant = 2;
        // and : on demande le calcule du score
        Float resScore = uneQuestion.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu est 100 divisé par le nombre de bonnes réponses possible
        assertEquals(new Float(100f/3), resScore);
        // when : un Etudiant fourni l'indice correspondant à une mauvaise réponse
        indiceEtudiant = 4;
        resScore = uneQuestion.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu est 100
        assertEquals(new Float(0f), resScore);
    }
}