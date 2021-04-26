package be.vdab.fietsen.repositories;

import be.vdab.fietsen.domain.Adres;
import be.vdab.fietsen.domain.Campus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@Import(JpaCampusRepository.class)
@Sql("/insertCampus.sql")
public class JpaCampusRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String CAMPUSSEN ="campussen";
    private JpaCampusRepository repository;

    public JpaCampusRepositoryTest(JpaCampusRepository repository) {
        this.repository = repository;
    }
    private long idVanTestCampus(){
        return jdbcTemplate.queryForObject(
                "select id from campussen where naam = 'test'",Long.class
        );
    }
    @Test
    void findById(){
        var campus = repository.findById(idVanTestCampus()).get();
        assertThat(campus.getNaam()).isEqualTo("test");
    }
    @Test
    void findByOnbestaandeId(){
        assertThat(repository.findById(-1)).isNotPresent();
    }
    @Test
    void create(){
        var campus = new Campus("test",new Adres("test","test","test","test"));
        repository.create(campus);
        assertThat(countRowsInTableWhere(CAMPUSSEN,
                "id="+campus.getId())).isOne();
    }
}
