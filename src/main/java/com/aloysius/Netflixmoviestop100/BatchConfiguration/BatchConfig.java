package com.aloysius.Netflixmoviestop100.BatchConfiguration;

import com.aloysius.Netflixmoviestop100.InputData.DataProcessor;
import com.aloysius.Netflixmoviestop100.InputData.NetflixData;
import com.aloysius.Netflixmoviestop100.InputData.NetflixInput;
import com.aloysius.Netflixmoviestop100.NetflixDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {

    private final NetflixDataRepository netflixDataRepository;
    private String [] FIELD_NAMES = {"Rank", "Movie_Title", "Year", "Score", "Director", "Cast", "Critics_Consensus"};
    //Job
    @Bean
    public Job importUserJob(JobRepository jobRepository,
                             Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }
    //STep
    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, RepositoryItemWriter<NetflixData> writer) {
        return new StepBuilder("step1", jobRepository)
                .<NetflixInput, NetflixData>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }

    //Writer
    @Bean
    public RepositoryItemWriter<NetflixData> writer(NetflixDataRepository netflixDataRepository){
        return new RepositoryItemWriterBuilder<NetflixData>()
                .repository(netflixDataRepository)
                .methodName("save")
                .build();
    }
    //processor
    @Bean
    public DataProcessor processor(){
        return new DataProcessor();

    }
    //reader
    @Bean
    public FlatFileItemReader<NetflixInput> reader(){
        return new FlatFileItemReaderBuilder<NetflixInput>()
                .name("NetflixInputReader")
                .resource(new ClassPathResource("100 Best Movies on Netflix.csv"))
                .delimited()
                .names(FIELD_NAMES)
                .linesToSkip(1)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<NetflixInput>(){{
                    setTargetType(NetflixInput.class);
                }})
                .build();
    }
}
