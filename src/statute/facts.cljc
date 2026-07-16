(ns statute.facts
  "General-law compliance catalog for Egypt (EGY) -- extends this
  repo's existing `marketentry.facts` (narrow public-procurement
  scope) with a second, orthogonal catalog of statutes a company
  generally must track for compliance. Mirrors
  cloud-itonami-iso3166-jpn/-usa/-esp/-swe/-nor/-dnk/-fin/-prt/-bel/-bra/-mex/-chl/-arg/-zaf/-col/-ury/-cri/-pan/-ecu/-pry/-gtm/-hnd/-ind/-ken/-tha/-are/-vnm/-idn/-phl's
  `statute.facts` (ADR-2607141700, cloud-itonami-compliance-fact-federation).

  Reuses this tick-window's already-verified capital/organization data
  from cloud-itonami-municipality-egy-cairo (Egypt Q79, Cairo Q85,
  capital status carrying a documented, transparently-recorded
  ambiguity given the ongoing New Capital relocation).

  Law No. 159 of 1981 (Companies Law) -- title/number/dates directly
  confirmed via lawyeregypt.net (an Egyptian legal-information site,
  the same source used successfully at tick 110 for Cairo's Local
  Government System Law): signed 17 September 1981, published in
  Official Gazette Issue 40 on 1 October 1981; a GAFI (General
  Authority for Investment) PDF mirror was attempted first but
  rendered entirely illegible via font-subsetting. Law No. 151 of
  2020 (Personal Data Protection Law) -- directly confirmed by reading
  mcit.gov.eg's (Ministry of Communications and Information
  Technology) own hosted Official Gazette PDF: the cover page shows
  'Issue No. 28 bis (h), 63rd year, 15 July 2020'; the law's own text
  states it was 'Issued at the Presidency of the Republic on 22 Dhu
  al-Qi'dah 1441 AH (corresponding to 13 July 2020)' -- the
  presidential signature line was incidentally visible but is never
  stored here, per this project's standing no-personal-names
  discipline.

  A law not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of statute entries."
  {"EGY"
   [{:statute/id "egy.law-159-1981-companies-law"
     :statute/title "Law No. 159 of 1981 Regarding the Issuance of the Law on Joint Stock Companies, Limited Partnership Companies with Shares, Limited Liability Companies, and Single-Person Companies"
     :statute/jurisdiction "EGY"
     :statute/kind :law
     :statute/law-number "Law No. 159 of 1981"
     :statute/url "https://lawyeregypt.net/%D8%A7%D9%84%D9%85%D9%83%D8%AA%D8%A8%D8%A9-%D8%A7%D9%84%D9%82%D8%A7%D9%86%D9%88%D9%86%D9%8A%D8%A9/%D9%82%D8%A7%D9%86%D9%88%D9%86-%D8%A7%D9%84%D8%B4%D8%B1%D9%83%D8%A7%D8%AA-%D8%B1%D9%82%D9%85-159-%D9%84%D8%B3%D9%86%D8%A9-1981/"
     :statute/url-provenance :lawyeregypt-net-legal-database
     :statute/enacted-date "1981-09-17"
     :statute/retrieved-at "2026-07-16"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "egy.law-151-2020-personal-data-protection"
     :statute/title "Personal Data Protection Law"
     :statute/jurisdiction "EGY"
     :statute/kind :law
     :statute/law-number "Law No. 151 of 2020"
     :statute/url "https://mcit.gov.eg/Upcont/Documents/Reports%20and%20Documents_1232021000_Law_No_151_2020_Personal_Data_Protection.pdf"
     :statute/url-provenance :official-mcit-gov-eg
     :statute/enacted-date "2020-07-13"
     :statute/retrieved-at "2026-07-16"
     :statute/topic #{:data-protection :privacy}}]})

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
      :note (str "cloud-itonami-iso3166-egy statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "EGY")) " EGY statutes seeded with "
                 "lawyeregypt.net/mcit.gov.eg citations. Extend "
                 "`statute.facts/catalog`, never fabricate a law-id or URL.")})))

(defn by-topic [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
