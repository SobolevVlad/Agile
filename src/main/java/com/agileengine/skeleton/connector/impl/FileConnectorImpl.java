package com.agileengine.skeleton.connector.impl;

import com.agileengine.skeleton.connector.FileConnector;
import com.agileengine.skeleton.dto.OrderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component("fileConnector")
public class FileConnectorImpl implements FileConnector {

    @Autowired
    private static final Logger LOGGER = LoggerFactory.getLogger(FileConnectorImpl.class);


    @Override
    public List<OrderDto> loadData(String stringPath) {
        try {
            Path path = Paths.get(stringPath);
            return Files.lines(path).skip(1).filter(this::isValidElementNumber).
                    filter(this::validateRowContent).map(this::convertRowToDto).collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("Cannot find file by path " + stringPath);
            return Collections.EMPTY_LIST;
        }
    }

    private boolean validateRowContent(String s) {
        String[] splitRow = s.split(",");
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS", Locale.ENGLISH);
        return validateRowContent(splitRow, df);
    }

    private OrderDto convertRowToDto(String line) {
        String[] splitRow = line.split(",");
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS", Locale.ENGLISH);
        Date parsedDate = null;
        try {
            parsedDate = df.parse(splitRow[2]);
        } catch (ParseException e) {
            //Not reachable
        }
        return new OrderDto(splitRow[0], splitRow[1], parsedDate, Integer.valueOf(splitRow[3]),
                    Integer.valueOf(splitRow[4]), splitRow[5], splitRow[6],
                    splitRow[7], splitRow[8], splitRow[9], splitRow[10]);
    }

    private static boolean validateRowContent(String[] splitRow, DateFormat df) {
        try {
            df.parse(splitRow[2]);
            Integer.valueOf(splitRow[3]);
            Integer.valueOf(splitRow[4]);
        } catch (NumberFormatException nfe) {
            LOGGER.warn("Can not parse integer value");
            return false;
        } catch (ParseException e) {
            LOGGER.warn("Date " + splitRow[2] + " was got in wrong format");
            return false;
        }
        return true;
    }

    private boolean isValidElementNumber(String line) {
        return 11 == line.split(",").length;
    }
}
