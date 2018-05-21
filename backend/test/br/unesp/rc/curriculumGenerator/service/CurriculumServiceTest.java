package br.unesp.rc.curriculumGenerator.service;

import br.unesp.rc.curriculumGenerator.model.Curriculum;
import org.junit.*;

import java.util.List;

public class CurriculumServiceTest {
    int userId;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        userId = 1;
    }

    @After
    public void tearDown() {
    }

    @Test
    public void selectCurriculumByUserIdTest() {
        CurriculumService curriculumService = FactoryService.getCurriculumService();
        List<Curriculum> curriculumList = curriculumService.selectCurriculumByUserId(userId);

        // Assert objects not null
        Assert.assertNotNull(curriculumList);

        for (Curriculum curriculum : curriculumList) {
            Assert.assertNotNull(curriculum.getAbilities());
            Assert.assertNotNull(curriculum.getFormations());
            Assert.assertNotNull(curriculum.getProfessionalExperiences());
            Assert.assertNotNull(curriculum.getLanguages());
        }
    }
}
