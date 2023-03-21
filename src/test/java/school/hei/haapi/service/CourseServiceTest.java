@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        // Initialisation des données de test
        User teacher = User.builder().username("Mr Aby").build();
        Course existingCourse = Course.builder()
                .courseId("course001")
                .code("Data2")
                .name("Learn data with me")
                .credits(3)
                .totalHours(45)
                .teacher(teacher)
                .build();
        courseRepository.save(existingCourse);
    }

    @AfterEach
    void tearDown() {
        // Suppression des données de test
        courseRepository.deleteAll();
    }

    @Test
    void testCreateOrUpdateCourseUpdate() {
        // Données de test
        Course newCourse = Course.builder()
                .code("Data2")
                .name("Learn data with me")
                .credits(4)
                .totalHours(60)
                .build();

        // Appel de la méthode à tester
        Course updatedCourse = courseService.createOrUpdateCourse(newCourse, "course001");

        // Vérifications
        assertThat(updatedCourse.getCourseId()).isEqualTo("course001");
        assertThat(updatedCourse.getCode()).isEqualTo("Data2");
        assertThat(updatedCourse.getName()).isEqualTo("Learn data with me");
        assertThat(updatedCourse.getCredits()).isEqualTo(4);
        assertThat(updatedCourse.getTotalHours()).isEqualTo(60);
        assertThat(updatedCourse.getTeacher()).isNull();
    }
}
