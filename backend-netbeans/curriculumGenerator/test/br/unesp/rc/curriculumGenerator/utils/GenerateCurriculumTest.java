package br.unesp.rc.curriculumGenerator.utils;

import br.unesp.rc.curriculumGenerator.apachepoi.utils.CurriculumModel1;
import br.unesp.rc.curriculumGenerator.apachepoi.utils.GenerateCurriculum;
import br.unesp.rc.curriculumGenerator.model.Curriculum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.*;

import java.io.File;
import java.io.IOException;

public class GenerateCurriculumTest {
    String curriculumJSON = "";

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        curriculumJSON = "{\"idCurriculum\":0,\"name\":\"Seu Nome\",\"country\":\"Brasil\",\"state\":\"São Paulo\",\"city\":\"Santa Bárbara d'Oeste\",\"cellPhone\":\"(19) 9 98423-7308\",\"email\":\"brunoovedoveto@gmail.com\",\"github\":\"https://github.com/bleandro\",\"linkedin\":null,\"objective\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum.\",\"summary\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum.\\n\\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum.\\n\\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum.\",\"user\":null,\"abilities\":[{\"name\":\"Habilidade 1\"},{\"name\":\"Habilidade 2\"},{\"name\":\"Habilidade 3\"}],\"formations\":[{\"name\":\"Bacharelado em Ciências da Computação\",\"institution\":\"UNESP\",\"startDate\":\"2014\",\"finalDate\":\"Julho/2018\",\"location\":\"Rio Claro, São Paulo\"},{\"name\":\"Técnico em Informática\",\"institution\":\"ETEC Deputado Ary de Camargo Pedroso\",\"startDate\":\"2012\",\"finalDate\":\"2013\",\"location\":\"Piracicaba, São Paulo\"}],\"languages\":[{\"name\":\"Inglês\",\"languageProeficiency\":\"ADVANCED\"},{\"name\":\"Espanhol\",\"languageProeficiency\":\"FLUENT\"}],\"professionalExperiences\":[{\"job\":\"Estagiário Desenvolvimento Web\",\"startDate\":\"Janeiro 2017\",\"finalDate\":\"Atualmente\",\"company\":\"Empresa\",\"location\":\"Cidade, Estado\",\"jobDescription\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed luctus tempus dolor, non volutpat neque rutrum aliquam. Interdum et malesuada fames ac ante ipsum primis in faucibus.\"},{\"job\":\"Estagiário de Desenvolvimento\",\"startDate\":\"Agosto\",\"finalDate\":\"Dezembro 2016\",\"company\":\"Empresa\",\"location\":\"Cidade, São Paulo\",\"jobDescription\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed luctus tempus dolor, non volutpat neque rutrum aliquam. Interdum et malesuada fames ac ante ipsum primis in faucibus.\"}]}";
    }

    @After
    public void tearDown() {
    }

    @Test
    public void model1() throws IOException {
        //JSON from String to Object
        Curriculum curriculum = new ObjectMapper().readValue(curriculumJSON, Curriculum.class);

        //Set default name at user's curriculum If not defined
        String userName = curriculum.getName();
        if (userName == null || userName.isEmpty())
            curriculum.setName("Default Name");

        GenerateCurriculum generateCurriculum = new CurriculumModel1();
        File generatedCurriculum = generateCurriculum.Export(curriculum);

        Assert.assertNotNull(generatedCurriculum);
    }

    @Test
    public void model2() {
    }

    @Test
    public void model3() {
    }
}
