package com.bl.base.backend.testdata;

import com.bl.base.backend.core.domain.Author;

import java.util.Set;

public class AuthorTestData {
    public static final Author TEST_AUTHOR_1 = new Author(
            1L,
            "Paul",
            "Nordholt",
            Set.of()
    );
}
