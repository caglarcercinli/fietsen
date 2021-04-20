package be.vdab.fietsen.services;

import be.vdab.fietsen.domain.Docent;
import be.vdab.fietsen.domain.Geslacht;
import be.vdab.fietsen.exceptions.DocentNietGevondenException;
import be.vdab.fietsen.repositories.DocentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultDocentServiceTest {
    private DefaultDocentService service;
    @Mock
    private DocentRepository repository;
    private Docent docent;
    @BeforeEach
    void beforeEach(){
        service = new DefaultDocentService(repository);
        docent = new Docent("test","test",
                BigDecimal.valueOf(100),"test@test.be", Geslacht.MAN);
    }
    @Test
    void opslag(){
        when(repository.findById(1)).thenReturn(Optional.of(docent));
        service.opslag(1,BigDecimal.TEN);
        assertThat(docent.getWedde()).isEqualByComparingTo("110");
        verify(repository).findById(1);
    }
    @Test
    void opslagVoorOnbestaandeDocent(){
        assertThatExceptionOfType(DocentNietGevondenException.class).isThrownBy(
                ()->service.opslag(-1,BigDecimal.TEN)
        );
        verify(repository).findById(-1);
    }
}
