(ns culture.facts
  "Country-level regional-culture catalog for Egypt (EGY) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"EGY"
   [{:culture/id "egy.dish.koshary"
     :culture/name "Koshary"
     :culture/name-local "كشري"
     :culture/country "EGY"
     :culture/kind :dish
     :culture/summary "Egypt's national dish and a widely popular street food of pasta, rice, lentils and fried onions; designated UNESCO intangible cultural heritage in 2025."
     :culture/url "https://en.wikipedia.org/wiki/Koshary"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "egy.dish.ful-medames"
     :culture/name "Ful medames"
     :culture/country "EGY"
     :culture/kind :dish
     :culture/summary "Stew of cooked fava beans, a staple food in Egypt considered a national dish, with variations spread throughout the MENA region."
     :culture/url "https://en.wikipedia.org/wiki/Ful_medames"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "egy.dish.mulukhiyah"
     :culture/name "Mulukhiyah"
     :culture/country "EGY"
     :culture/kind :dish
     :culture/summary "Traditional Egyptian and Arab dish of jute leaves; many Egyptians consider molokhiyya a national dish of Egypt, and it has spread across North Africa and the Middle East."
     :culture/url "https://en.wikipedia.org/wiki/Mulukhiyah"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "egy.dish.hawawshi"
     :culture/name "Hawawshi"
     :culture/country "EGY"
     :culture/kind :dish
     :culture/summary "Traditional Egyptian dish of pita bread stuffed with spiced minced meat, originating from Egypt and now found across the Middle East and North Africa."
     :culture/url "https://en.wikipedia.org/wiki/Hawawshi"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "egy.beverage.karkade"
     :culture/name "Karkadé (hibiscus tea)"
     :culture/country "EGY"
     :culture/kind :beverage
     :culture/summary "Beverage made from roselle flowers, commonly sold by vendors in Cairo; in Egypt and Sudan wedding celebrations are traditionally toasted with a glass of hibiscus tea."
     :culture/url "https://en.wikipedia.org/wiki/Hibiscus_tea"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "egy.craft.khayamiya"
     :culture/name "Khayamiya"
     :culture/country "EGY"
     :culture/kind :craft
     :culture/summary "Decorative Egyptian appliqué textile art dating back as far as Ancient Egypt, primarily handmade in Cairo's historic Street of the Tentmakers."
     :culture/url "https://en.wikipedia.org/wiki/Khayamiya"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "egy.festival.sham-ennessim"
     :culture/name "Sham Ennessim"
     :culture/country "EGY"
     :culture/kind :festival
     :culture/summary "Egyptian spring festival celebrated on Easter Monday by Egyptians of all religions, with origins dating back over 4,500 years."
     :culture/url "https://en.wikipedia.org/wiki/Sham_Ennessim"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "egy.heritage.giza-pyramids"
     :culture/name "Giza pyramid complex"
     :culture/country "EGY"
     :culture/kind :heritage
     :culture/summary "Archaeological site near Cairo including the Great Pyramid and the Great Sphinx, part of the UNESCO World Heritage Site Memphis and its Necropolis inscribed in 1979."
     :culture/url "https://en.wikipedia.org/wiki/Giza_pyramid_complex"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "egy.heritage.abu-simbel"
     :culture/name "Abu Simbel"
     :culture/country "EGY"
     :culture/kind :heritage
     :culture/summary "Two massive rock-cut temples in southern Egypt built by Ramesses II, relocated in 1968 to avoid submersion and part of the Nubian Monuments UNESCO World Heritage Site designated in 1979."
     :culture/url "https://en.wikipedia.org/wiki/Abu_Simbel"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-egy culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "EGY"))
                 " EGY entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
