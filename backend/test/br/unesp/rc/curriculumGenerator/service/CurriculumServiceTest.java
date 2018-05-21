package br.unesp.rc.curriculumGenerator.service;

import br.unesp.rc.curriculumGenerator.model.Curriculum;
import org.junit.*;

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
        Curriculum curriculum = curriculumService.selectCurriculumByUserId(userId);

        // Assert objects not null
        Assert.assertNotNull(curriculum);
        Assert.assertNotNull(curriculum.getAbilities());
        Assert.assertNotNull(curriculum.getFormations());
        Assert.assertNotNull(curriculum.getProfessionalExperiences());
        Assert.assertNotNull(curriculum.getLanguages());
    }
}
