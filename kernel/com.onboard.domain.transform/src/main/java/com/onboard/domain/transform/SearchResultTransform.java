/*******************************************************************************
 * Copyright [2015] [Onboard team of SERC, Peking University]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.onboard.domain.transform;

import com.google.common.collect.Lists;
import com.onboard.dto.SearchResultDTO;
import com.onboard.service.index.model.SearchResult;

public class SearchResultTransform {

    public static SearchResultDTO searchItemsToSearchResult(SearchResult searchResult) {
        SearchResultDTO searchResultDTO = new SearchResultDTO();
        searchResultDTO.setHasNext(searchResult.isHasNext());
        if (searchResult.getResults() != null) {
            searchResultDTO.setResults(Lists.newArrayList(Lists.transform(searchResult.getResults(),
                    IndexDocumentTransForm.INDEXDOCUMENT_DTO_FUNCTION)));
        }
        return searchResultDTO;
    }
}
