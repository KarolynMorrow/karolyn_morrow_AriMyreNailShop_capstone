package com.perscholas.AriMyreNailShop.Treatment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TreatmentRepositoryTest {

    private final TreatmentService treatmentService;
    private final TreatmentRepository treatmentRepository;

    @Autowired
    public TreatmentRepositoryTest(TreatmentService treatmentService, TreatmentRepository treatmentRepository) {
        this.treatmentService = treatmentService;
        this.treatmentRepository = treatmentRepository;
    }

    @Test
    void findByServiceNameShouldReturnCorrectService() {
        Treatment expected = new Treatment();
        expected.setServiceName("Mani-Pedi");
        expected.setServicePrice(50);
        expected.setServiceId(50);
        expected.setDescription("Both Mani and Pedi special");
        treatmentService.save(expected);

        Optional<Treatment> actual = treatmentRepository.findByServiceName(expected.getServiceName());
        assertEquals(expected, actual.orElse(null));
    }



    @Test
    void findByServiceIdShouldReturnCorrectService() {
        Treatment expected = new Treatment();
        expected.setServiceName("Mani-Pedi");
        expected.setServicePrice(50);
        expected.setServiceId(50);
        expected.setDescription("Both Mani and Pedi special");
        treatmentService.save(expected);

        Optional<Treatment> actual = treatmentRepository.findByServiceId(expected.getServiceId());
        assertEquals(expected, actual.orElse(null));

    }

    @Test
    void findByUsernameShouldReturnNullForNonExistentTreatment() {
        // Call the findByServiceName method for a non-existent treatment
        Optional<Treatment> nonexistentTreatment = treatmentRepository.findByServiceName("nonexistent");

        // Assert that the returned treatment is empty/not optional at the time
        assertEquals(Optional.empty(), nonexistentTreatment);
    }

}