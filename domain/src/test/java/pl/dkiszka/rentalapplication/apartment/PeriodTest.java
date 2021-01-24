package pl.dkiszka.rentalapplication.apartment;

import org.assertj.core.util.Lists;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 24.01.2021
 */
class PeriodTest {

    @ParameterizedTest
    @MethodSource("daysBetweenStartAndEnd")
    void shoul_return_all_days_between_start_and_end(LocalDate start, LocalDate end, Iterable<LocalDate> expected) {
        var actual = new Period(start, end).asDays();
        assertThat(actual).containsExactlyElementsOf(expected);
    }


    private static Stream<Arguments> daysBetweenStartAndEnd() {
        return Stream.of(
                Arguments.of(
                        LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 2),
                        Lists.newArrayList(LocalDate.of(2020, 1, 1),
                                LocalDate.of(2020, 1, 2))

                ),
                Arguments.of(
                        LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 3),
                        Lists.newArrayList(LocalDate.of(2020, 1, 1),
                                LocalDate.of(2020, 1, 2),
                                LocalDate.of(2020, 1, 3))

                ),
                Arguments.of(
                        LocalDate.of(2020, 5, 5), LocalDate.of(2020, 5, 10),
                        Lists.newArrayList(LocalDate.of(2020, 5, 5),
                                LocalDate.of(2020, 5, 6),
                                LocalDate.of(2020, 5, 7),
                                LocalDate.of(2020, 5, 8),
                                LocalDate.of(2020, 5, 9),
                                LocalDate.of(2020, 5, 10)
                        )

                )
        );
    }
}
