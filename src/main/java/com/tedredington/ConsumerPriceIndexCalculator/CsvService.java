package com.tedredington.ConsumerPriceIndexCalculator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {

    private final Logger logger = LoggerFactory.getLogger(CsvService.class);

    @Value("classpath:data/GDPDEF.csv")
    private Resource resourceFile;

    public List<GDPDefRecord> readCsv() throws Exception {

        List<GDPDefRecord> records = new ArrayList<>();

        Reader reader = new FileReader(resourceFile.getFile());
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setHeader().build();
        CSVParser csvParser = new CSVParser(reader, csvFormat);

        for (CSVRecord csvRecord : csvParser) {
            LocalDate date = LocalDate.parse(csvRecord.get("DATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Double indexValue = Double.parseDouble(csvRecord.get("GDPDEF"));
            GDPDefRecord record = new GDPDefRecord(date, indexValue); 
            logger.info("Parsed new record: " + record);
            records.add(record);
        }
        return records;
    }

}
