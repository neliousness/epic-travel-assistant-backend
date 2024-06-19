package mz.co.vodacom.challenge.epictravelassistant.models.dtos


data class CountryResponseDto(
    val gdp: Double,
    val sex_ratio: Double,
    val surface_area: Double,
    val life_expectancy_male: Double,
    val unemployment: Double,
    val imports: Double,
    val homicide_rate: Double,
    val currency: Currency,
    val iso2: String,
    val employment_services: Double,
    val employment_industry: Double,
    val urban_population_growth: Double,
    val secondary_school_enrollment_female: Double,
    val employment_agriculture: Double,
    val capital: String,
    val co2_emissions: Double,
    val forested_area: Double,
    val tourists: Double,
    val exports: Double,
    val life_expectancy_female: Double,
    val post_secondary_enrollment_female: Double,
    val post_secondary_enrollment_male: Double,
    val primary_school_enrollment_female: Double,
    val infant_mortality: Double,
    val gdp_growth: Double,
    val threatened_species: Int,
    val population: Int,
    val urban_population: Double,
    val secondary_school_enrollment_male: Double,
    val name: String,
    val pop_growth: Double,
    val region: String,
    val pop_density: Double,
    val internet_users: Double,
    val gdp_per_capita: Double,
    val fertility: Double,
    val refugees: Double,
    val primary_school_enrollment_male: Double
)

data class Currency(
    val code: String,
    val name: String
)
