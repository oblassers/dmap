
package at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for languages.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="languages">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="deu"/>
 *     &lt;enumeration value="eng"/>
 *     &lt;enumeration value="fra"/>
 *     &lt;enumeration value="aar"/>
 *     &lt;enumeration value="abk"/>
 *     &lt;enumeration value="afr"/>
 *     &lt;enumeration value="aka"/>
 *     &lt;enumeration value="amh"/>
 *     &lt;enumeration value="ara"/>
 *     &lt;enumeration value="arg"/>
 *     &lt;enumeration value="asm"/>
 *     &lt;enumeration value="ava"/>
 *     &lt;enumeration value="ave"/>
 *     &lt;enumeration value="aym"/>
 *     &lt;enumeration value="aze"/>
 *     &lt;enumeration value="bak"/>
 *     &lt;enumeration value="bam"/>
 *     &lt;enumeration value="bel"/>
 *     &lt;enumeration value="ben"/>
 *     &lt;enumeration value="bis"/>
 *     &lt;enumeration value="bod"/>
 *     &lt;enumeration value="bos"/>
 *     &lt;enumeration value="bre"/>
 *     &lt;enumeration value="bul"/>
 *     &lt;enumeration value="cat"/>
 *     &lt;enumeration value="ces"/>
 *     &lt;enumeration value="cha"/>
 *     &lt;enumeration value="che"/>
 *     &lt;enumeration value="chu"/>
 *     &lt;enumeration value="chv"/>
 *     &lt;enumeration value="cor"/>
 *     &lt;enumeration value="cos"/>
 *     &lt;enumeration value="cre"/>
 *     &lt;enumeration value="cym"/>
 *     &lt;enumeration value="dan"/>
 *     &lt;enumeration value="div"/>
 *     &lt;enumeration value="dzo"/>
 *     &lt;enumeration value="ell"/>
 *     &lt;enumeration value="epo"/>
 *     &lt;enumeration value="est"/>
 *     &lt;enumeration value="eus"/>
 *     &lt;enumeration value="ewe"/>
 *     &lt;enumeration value="fao"/>
 *     &lt;enumeration value="fas"/>
 *     &lt;enumeration value="fij"/>
 *     &lt;enumeration value="fin"/>
 *     &lt;enumeration value="fry"/>
 *     &lt;enumeration value="ful"/>
 *     &lt;enumeration value="gla"/>
 *     &lt;enumeration value="gle"/>
 *     &lt;enumeration value="glg"/>
 *     &lt;enumeration value="glv"/>
 *     &lt;enumeration value="grn"/>
 *     &lt;enumeration value="guj"/>
 *     &lt;enumeration value="hat"/>
 *     &lt;enumeration value="hau"/>
 *     &lt;enumeration value="heb"/>
 *     &lt;enumeration value="her"/>
 *     &lt;enumeration value="hin"/>
 *     &lt;enumeration value="hmo"/>
 *     &lt;enumeration value="hrv"/>
 *     &lt;enumeration value="hun"/>
 *     &lt;enumeration value="hye"/>
 *     &lt;enumeration value="ibo"/>
 *     &lt;enumeration value="ido"/>
 *     &lt;enumeration value="iii"/>
 *     &lt;enumeration value="iku"/>
 *     &lt;enumeration value="ile"/>
 *     &lt;enumeration value="ina"/>
 *     &lt;enumeration value="ind"/>
 *     &lt;enumeration value="ipk"/>
 *     &lt;enumeration value="isl"/>
 *     &lt;enumeration value="ita"/>
 *     &lt;enumeration value="jav"/>
 *     &lt;enumeration value="jpn"/>
 *     &lt;enumeration value="kal"/>
 *     &lt;enumeration value="kan"/>
 *     &lt;enumeration value="kas"/>
 *     &lt;enumeration value="kat"/>
 *     &lt;enumeration value="kau"/>
 *     &lt;enumeration value="kaz"/>
 *     &lt;enumeration value="khm"/>
 *     &lt;enumeration value="kik"/>
 *     &lt;enumeration value="kin"/>
 *     &lt;enumeration value="kir"/>
 *     &lt;enumeration value="kom"/>
 *     &lt;enumeration value="kon"/>
 *     &lt;enumeration value="kor"/>
 *     &lt;enumeration value="kua"/>
 *     &lt;enumeration value="kur"/>
 *     &lt;enumeration value="lao"/>
 *     &lt;enumeration value="lat"/>
 *     &lt;enumeration value="lav"/>
 *     &lt;enumeration value="lim"/>
 *     &lt;enumeration value="lin"/>
 *     &lt;enumeration value="lit"/>
 *     &lt;enumeration value="ltz"/>
 *     &lt;enumeration value="lub"/>
 *     &lt;enumeration value="lug"/>
 *     &lt;enumeration value="mah"/>
 *     &lt;enumeration value="mal"/>
 *     &lt;enumeration value="mar"/>
 *     &lt;enumeration value="mkd"/>
 *     &lt;enumeration value="mlg"/>
 *     &lt;enumeration value="mlt"/>
 *     &lt;enumeration value="mon"/>
 *     &lt;enumeration value="mri"/>
 *     &lt;enumeration value="msa"/>
 *     &lt;enumeration value="mya"/>
 *     &lt;enumeration value="nau"/>
 *     &lt;enumeration value="nav"/>
 *     &lt;enumeration value="nbl"/>
 *     &lt;enumeration value="nde"/>
 *     &lt;enumeration value="ndo"/>
 *     &lt;enumeration value="nep"/>
 *     &lt;enumeration value="nld"/>
 *     &lt;enumeration value="nno"/>
 *     &lt;enumeration value="nob"/>
 *     &lt;enumeration value="nor"/>
 *     &lt;enumeration value="nya"/>
 *     &lt;enumeration value="oci"/>
 *     &lt;enumeration value="oji"/>
 *     &lt;enumeration value="ori"/>
 *     &lt;enumeration value="orm"/>
 *     &lt;enumeration value="oss"/>
 *     &lt;enumeration value="pan"/>
 *     &lt;enumeration value="pli"/>
 *     &lt;enumeration value="pol"/>
 *     &lt;enumeration value="por"/>
 *     &lt;enumeration value="pus"/>
 *     &lt;enumeration value="que"/>
 *     &lt;enumeration value="roh"/>
 *     &lt;enumeration value="ron"/>
 *     &lt;enumeration value="run"/>
 *     &lt;enumeration value="rus"/>
 *     &lt;enumeration value="sag"/>
 *     &lt;enumeration value="san"/>
 *     &lt;enumeration value="sin"/>
 *     &lt;enumeration value="slk"/>
 *     &lt;enumeration value="slv"/>
 *     &lt;enumeration value="sme"/>
 *     &lt;enumeration value="smo"/>
 *     &lt;enumeration value="sna"/>
 *     &lt;enumeration value="snd"/>
 *     &lt;enumeration value="som"/>
 *     &lt;enumeration value="sot"/>
 *     &lt;enumeration value="spa"/>
 *     &lt;enumeration value="sqi"/>
 *     &lt;enumeration value="srd"/>
 *     &lt;enumeration value="srp"/>
 *     &lt;enumeration value="ssw"/>
 *     &lt;enumeration value="sun"/>
 *     &lt;enumeration value="swa"/>
 *     &lt;enumeration value="swe"/>
 *     &lt;enumeration value="tah"/>
 *     &lt;enumeration value="tam"/>
 *     &lt;enumeration value="tat"/>
 *     &lt;enumeration value="tel"/>
 *     &lt;enumeration value="tgk"/>
 *     &lt;enumeration value="tgl"/>
 *     &lt;enumeration value="tha"/>
 *     &lt;enumeration value="tir"/>
 *     &lt;enumeration value="ton"/>
 *     &lt;enumeration value="tsn"/>
 *     &lt;enumeration value="tso"/>
 *     &lt;enumeration value="tuk"/>
 *     &lt;enumeration value="tur"/>
 *     &lt;enumeration value="twi"/>
 *     &lt;enumeration value="uig"/>
 *     &lt;enumeration value="ukr"/>
 *     &lt;enumeration value="urd"/>
 *     &lt;enumeration value="uzb"/>
 *     &lt;enumeration value="ven"/>
 *     &lt;enumeration value="vie"/>
 *     &lt;enumeration value="vol"/>
 *     &lt;enumeration value="wln"/>
 *     &lt;enumeration value="wol"/>
 *     &lt;enumeration value="xho"/>
 *     &lt;enumeration value="yid"/>
 *     &lt;enumeration value="yor"/>
 *     &lt;enumeration value="zha"/>
 *     &lt;enumeration value="zho"/>
 *     &lt;enumeration value="zul"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "languages", namespace = "http://www.re3data.org/schema/2-2")
@XmlEnum
public enum Languages {


    /**
     * German
     * 
     */
    @XmlEnumValue("deu")
    DEU("deu"),

    /**
     * English
     * 
     */
    @XmlEnumValue("eng")
    ENG("eng"),

    /**
     * French
     * 
     */
    @XmlEnumValue("fra")
    FRA("fra"),

    /**
     * Afar
     * 
     */
    @XmlEnumValue("aar")
    AAR("aar"),

    /**
     * Abkhaz
     * 
     */
    @XmlEnumValue("abk")
    ABK("abk"),

    /**
     * Afrikaans
     * 
     */
    @XmlEnumValue("afr")
    AFR("afr"),

    /**
     * Akan
     * 
     */
    @XmlEnumValue("aka")
    AKA("aka"),

    /**
     * Amharic
     * 
     */
    @XmlEnumValue("amh")
    AMH("amh"),

    /**
     * Arabic
     * 
     */
    @XmlEnumValue("ara")
    ARA("ara"),

    /**
     * Aragonese
     * 
     */
    @XmlEnumValue("arg")
    ARG("arg"),

    /**
     * Assamese
     * 
     */
    @XmlEnumValue("asm")
    ASM("asm"),

    /**
     * Avaric
     * 
     */
    @XmlEnumValue("ava")
    AVA("ava"),

    /**
     * Avestan
     * 
     */
    @XmlEnumValue("ave")
    AVE("ave"),

    /**
     * Aymara
     * 
     */
    @XmlEnumValue("aym")
    AYM("aym"),

    /**
     * Azerbaijani
     * 
     */
    @XmlEnumValue("aze")
    AZE("aze"),

    /**
     * Bashkir
     * 
     */
    @XmlEnumValue("bak")
    BAK("bak"),

    /**
     * Bambara
     * 
     */
    @XmlEnumValue("bam")
    BAM("bam"),

    /**
     * Belarusian
     * 
     */
    @XmlEnumValue("bel")
    BEL("bel"),

    /**
     * Bengali
     * 
     */
    @XmlEnumValue("ben")
    BEN("ben"),

    /**
     * Bislama
     * 
     */
    @XmlEnumValue("bis")
    BIS("bis"),

    /**
     * Tibetan Standard, Tibetan, Central
     * 
     */
    @XmlEnumValue("bod")
    BOD("bod"),

    /**
     * Bosnian
     * 
     */
    @XmlEnumValue("bos")
    BOS("bos"),

    /**
     * Breton
     * 
     */
    @XmlEnumValue("bre")
    BRE("bre"),

    /**
     * Bulgarian
     * 
     */
    @XmlEnumValue("bul")
    BUL("bul"),

    /**
     * Catalan; Valencian
     * 
     */
    @XmlEnumValue("cat")
    CAT("cat"),

    /**
     * Czech
     * 
     */
    @XmlEnumValue("ces")
    CES("ces"),

    /**
     * Chamorro
     * 
     */
    @XmlEnumValue("cha")
    CHA("cha"),

    /**
     * Chechen
     * 
     */
    @XmlEnumValue("che")
    CHE("che"),

    /**
     * Old Church Slavonic, Church Slavic, Church Slavonic, Old Bulgarian, Old Slavonic
     * 
     */
    @XmlEnumValue("chu")
    CHU("chu"),

    /**
     * Chuvash
     * 
     */
    @XmlEnumValue("chv")
    CHV("chv"),

    /**
     * Cornish
     * 
     */
    @XmlEnumValue("cor")
    COR("cor"),

    /**
     * Corsican
     * 
     */
    @XmlEnumValue("cos")
    COS("cos"),

    /**
     * Cree
     * 
     */
    @XmlEnumValue("cre")
    CRE("cre"),

    /**
     * Welsh
     * 
     */
    @XmlEnumValue("cym")
    CYM("cym"),

    /**
     * Danish
     * 
     */
    @XmlEnumValue("dan")
    DAN("dan"),

    /**
     * Divehi; Dhivehi; Maldivian;
     * 
     */
    @XmlEnumValue("div")
    DIV("div"),

    /**
     * Dzongkha
     * 
     */
    @XmlEnumValue("dzo")
    DZO("dzo"),

    /**
     * Greek, Modern
     * 
     */
    @XmlEnumValue("ell")
    ELL("ell"),

    /**
     * Esperanto
     * 
     */
    @XmlEnumValue("epo")
    EPO("epo"),

    /**
     * Estonian
     * 
     */
    @XmlEnumValue("est")
    EST("est"),

    /**
     * Basque
     * 
     */
    @XmlEnumValue("eus")
    EUS("eus"),

    /**
     * Ewe
     * 
     */
    @XmlEnumValue("ewe")
    EWE("ewe"),

    /**
     * Faroese
     * 
     */
    @XmlEnumValue("fao")
    FAO("fao"),

    /**
     * Persian
     * 
     */
    @XmlEnumValue("fas")
    FAS("fas"),

    /**
     * Fijian
     * 
     */
    @XmlEnumValue("fij")
    FIJ("fij"),

    /**
     * Finnish
     * 
     */
    @XmlEnumValue("fin")
    FIN("fin"),

    /**
     * Western Frisian
     * 
     */
    @XmlEnumValue("fry")
    FRY("fry"),

    /**
     * Fula; Fulah; Pulaar; Pular
     * 
     */
    @XmlEnumValue("ful")
    FUL("ful"),

    /**
     * Scottish Gaelic; Gaelic
     * 
     */
    @XmlEnumValue("gla")
    GLA("gla"),

    /**
     * Irish
     * 
     */
    @XmlEnumValue("gle")
    GLE("gle"),

    /**
     * Galician
     * 
     */
    @XmlEnumValue("glg")
    GLG("glg"),

    /**
     * Manx
     * 
     */
    @XmlEnumValue("glv")
    GLV("glv"),

    /**
     * Guarani
     * 
     */
    @XmlEnumValue("grn")
    GRN("grn"),

    /**
     * Gujarati
     * 
     */
    @XmlEnumValue("guj")
    GUJ("guj"),

    /**
     * Haitian; Haitian Creole
     * 
     */
    @XmlEnumValue("hat")
    HAT("hat"),

    /**
     * Hausa
     * 
     */
    @XmlEnumValue("hau")
    HAU("hau"),

    /**
     * Hebrew (modern)
     * 
     */
    @XmlEnumValue("heb")
    HEB("heb"),

    /**
     * Herero
     * 
     */
    @XmlEnumValue("her")
    HER("her"),

    /**
     * Hindi
     * 
     */
    @XmlEnumValue("hin")
    HIN("hin"),

    /**
     * Hiri Motu
     * 
     */
    @XmlEnumValue("hmo")
    HMO("hmo"),

    /**
     * Croatian
     * 
     */
    @XmlEnumValue("hrv")
    HRV("hrv"),

    /**
     * Hungarian
     * 
     */
    @XmlEnumValue("hun")
    HUN("hun"),

    /**
     * Armenian
     * 
     */
    @XmlEnumValue("hye")
    HYE("hye"),

    /**
     * Igbo
     * 
     */
    @XmlEnumValue("ibo")
    IBO("ibo"),

    /**
     * Ido
     * 
     */
    @XmlEnumValue("ido")
    IDO("ido"),

    /**
     * Nuosu
     * 
     */
    @XmlEnumValue("iii")
    III("iii"),

    /**
     * Inuktitut
     * 
     */
    @XmlEnumValue("iku")
    IKU("iku"),

    /**
     * Interlingue
     * 
     */
    @XmlEnumValue("ile")
    ILE("ile"),

    /**
     * Interlingua
     * 
     */
    @XmlEnumValue("ina")
    INA("ina"),

    /**
     * Indonesian
     * 
     */
    @XmlEnumValue("ind")
    IND("ind"),

    /**
     * Inupiaq
     * 
     */
    @XmlEnumValue("ipk")
    IPK("ipk"),

    /**
     * Icelandic
     * 
     */
    @XmlEnumValue("isl")
    ISL("isl"),

    /**
     * Italian
     * 
     */
    @XmlEnumValue("ita")
    ITA("ita"),

    /**
     * Javanese
     * 
     */
    @XmlEnumValue("jav")
    JAV("jav"),

    /**
     * Japanese
     * 
     */
    @XmlEnumValue("jpn")
    JPN("jpn"),

    /**
     * Kalaallisut, Greenlandic
     * 
     */
    @XmlEnumValue("kal")
    KAL("kal"),

    /**
     * Kannada
     * 
     */
    @XmlEnumValue("kan")
    KAN("kan"),

    /**
     * Kashmiri
     * 
     */
    @XmlEnumValue("kas")
    KAS("kas"),

    /**
     * Georgian
     * 
     */
    @XmlEnumValue("kat")
    KAT("kat"),

    /**
     * Kanuri
     * 
     */
    @XmlEnumValue("kau")
    KAU("kau"),

    /**
     * Kazakh
     * 
     */
    @XmlEnumValue("kaz")
    KAZ("kaz"),

    /**
     * Khmer
     * 
     */
    @XmlEnumValue("khm")
    KHM("khm"),

    /**
     * Kikuyu, Gikuyu
     * 
     */
    @XmlEnumValue("kik")
    KIK("kik"),

    /**
     * Kinyarwanda
     * 
     */
    @XmlEnumValue("kin")
    KIN("kin"),

    /**
     * Kyrgyz
     * 
     */
    @XmlEnumValue("kir")
    KIR("kir"),

    /**
     * Komi
     * 
     */
    @XmlEnumValue("kom")
    KOM("kom"),

    /**
     * Kongo
     * 
     */
    @XmlEnumValue("kon")
    KON("kon"),

    /**
     * Korean
     * 
     */
    @XmlEnumValue("kor")
    KOR("kor"),

    /**
     * Kwanyama, Kuanyama
     * 
     */
    @XmlEnumValue("kua")
    KUA("kua"),

    /**
     * Kurdish
     * 
     */
    @XmlEnumValue("kur")
    KUR("kur"),

    /**
     * Lao
     * 
     */
    @XmlEnumValue("lao")
    LAO("lao"),

    /**
     * Latin
     * 
     */
    @XmlEnumValue("lat")
    LAT("lat"),

    /**
     * Latvian
     * 
     */
    @XmlEnumValue("lav")
    LAV("lav"),

    /**
     * Limburgish, Limburgan, Limburger
     * 
     */
    @XmlEnumValue("lim")
    LIM("lim"),

    /**
     * Lingala
     * 
     */
    @XmlEnumValue("lin")
    LIN("lin"),

    /**
     * Lithuanian
     * 
     */
    @XmlEnumValue("lit")
    LIT("lit"),

    /**
     * Luxembourgish, Letzeburgesch
     * 
     */
    @XmlEnumValue("ltz")
    LTZ("ltz"),

    /**
     * Luba-Katanga
     * 
     */
    @XmlEnumValue("lub")
    LUB("lub"),

    /**
     * Ganda
     * 
     */
    @XmlEnumValue("lug")
    LUG("lug"),

    /**
     * Marshallese
     * 
     */
    @XmlEnumValue("mah")
    MAH("mah"),

    /**
     * Malayalam
     * 
     */
    @XmlEnumValue("mal")
    MAL("mal"),

    /**
     * Marathi
     * 
     */
    @XmlEnumValue("mar")
    MAR("mar"),

    /**
     * Macedonian
     * 
     */
    @XmlEnumValue("mkd")
    MKD("mkd"),

    /**
     * Malagasy
     * 
     */
    @XmlEnumValue("mlg")
    MLG("mlg"),

    /**
     * Maltese
     * 
     */
    @XmlEnumValue("mlt")
    MLT("mlt"),

    /**
     * Mongolian
     * 
     */
    @XmlEnumValue("mon")
    MON("mon"),

    /**
     * Maori
     * 
     */
    @XmlEnumValue("mri")
    MRI("mri"),

    /**
     * Malay
     * 
     */
    @XmlEnumValue("msa")
    MSA("msa"),

    /**
     * Burmese
     * 
     */
    @XmlEnumValue("mya")
    MYA("mya"),

    /**
     * Nauru
     * 
     */
    @XmlEnumValue("nau")
    NAU("nau"),

    /**
     * Navajo, Navaho
     * 
     */
    @XmlEnumValue("nav")
    NAV("nav"),

    /**
     * South Ndebele
     * 
     */
    @XmlEnumValue("nbl")
    NBL("nbl"),

    /**
     * North Ndebele
     * 
     */
    @XmlEnumValue("nde")
    NDE("nde"),

    /**
     * Ndonga
     * 
     */
    @XmlEnumValue("ndo")
    NDO("ndo"),

    /**
     * Nepali
     * 
     */
    @XmlEnumValue("nep")
    NEP("nep"),

    /**
     * Dutch
     * 
     */
    @XmlEnumValue("nld")
    NLD("nld"),

    /**
     * Norwegian Nynorsk
     * 
     */
    @XmlEnumValue("nno")
    NNO("nno"),

    /**
     * Norwegian Bokmal
     * 
     */
    @XmlEnumValue("nob")
    NOB("nob"),

    /**
     * Norwegian
     * 
     */
    @XmlEnumValue("nor")
    NOR("nor"),

    /**
     * Chichewa; Chewa; Nyanja
     * 
     */
    @XmlEnumValue("nya")
    NYA("nya"),

    /**
     * Occitan
     * 
     */
    @XmlEnumValue("oci")
    OCI("oci"),

    /**
     * Ojibwe, Ojibwa
     * 
     */
    @XmlEnumValue("oji")
    OJI("oji"),

    /**
     * Oriya
     * 
     */
    @XmlEnumValue("ori")
    ORI("ori"),

    /**
     * Oromo
     * 
     */
    @XmlEnumValue("orm")
    ORM("orm"),

    /**
     * Ossetian, Ossetic
     * 
     */
    @XmlEnumValue("oss")
    OSS("oss"),

    /**
     * Panjabi, Punjabi
     * 
     */
    @XmlEnumValue("pan")
    PAN("pan"),

    /**
     * Pali
     * 
     */
    @XmlEnumValue("pli")
    PLI("pli"),

    /**
     * Polish
     * 
     */
    @XmlEnumValue("pol")
    POL("pol"),

    /**
     * Portuguese
     * 
     */
    @XmlEnumValue("por")
    POR("por"),

    /**
     * Pashto, Pushto
     * 
     */
    @XmlEnumValue("pus")
    PUS("pus"),

    /**
     * Quechua
     * 
     */
    @XmlEnumValue("que")
    QUE("que"),

    /**
     * Romansh
     * 
     */
    @XmlEnumValue("roh")
    ROH("roh"),

    /**
     * Romanian, Moldavian(Romanian from Republic of Moldova)
     * 
     */
    @XmlEnumValue("ron")
    RON("ron"),

    /**
     * Kirundi
     * 
     */
    @XmlEnumValue("run")
    RUN("run"),

    /**
     * Russian
     * 
     */
    @XmlEnumValue("rus")
    RUS("rus"),

    /**
     * Sango
     * 
     */
    @XmlEnumValue("sag")
    SAG("sag"),

    /**
     * Sanskrit (Samskrta)
     * 
     */
    @XmlEnumValue("san")
    SAN("san"),

    /**
     * Sinhala, Sinhalese
     * 
     */
    @XmlEnumValue("sin")
    SIN("sin"),

    /**
     * Slovak
     * 
     */
    @XmlEnumValue("slk")
    SLK("slk"),

    /**
     * Slovene
     * 
     */
    @XmlEnumValue("slv")
    SLV("slv"),

    /**
     * Northern Sami
     * 
     */
    @XmlEnumValue("sme")
    SME("sme"),

    /**
     * Samoan
     * 
     */
    @XmlEnumValue("smo")
    SMO("smo"),

    /**
     * Shona
     * 
     */
    @XmlEnumValue("sna")
    SNA("sna"),

    /**
     * Sindhi
     * 
     */
    @XmlEnumValue("snd")
    SND("snd"),

    /**
     * Somali
     * 
     */
    @XmlEnumValue("som")
    SOM("som"),

    /**
     * Southern Sotho
     * 
     */
    @XmlEnumValue("sot")
    SOT("sot"),

    /**
     * Spanish; Castilian
     * 
     */
    @XmlEnumValue("spa")
    SPA("spa"),

    /**
     * Albanian
     * 
     */
    @XmlEnumValue("sqi")
    SQI("sqi"),

    /**
     * Sardinian
     * 
     */
    @XmlEnumValue("srd")
    SRD("srd"),

    /**
     * Serbian
     * 
     */
    @XmlEnumValue("srp")
    SRP("srp"),

    /**
     * Swati
     * 
     */
    @XmlEnumValue("ssw")
    SSW("ssw"),

    /**
     * Sundanese
     * 
     */
    @XmlEnumValue("sun")
    SUN("sun"),

    /**
     * Swahili
     * 
     */
    @XmlEnumValue("swa")
    SWA("swa"),

    /**
     * Swedish
     * 
     */
    @XmlEnumValue("swe")
    SWE("swe"),

    /**
     * Tahitian
     * 
     */
    @XmlEnumValue("tah")
    TAH("tah"),

    /**
     * Tamil
     * 
     */
    @XmlEnumValue("tam")
    TAM("tam"),

    /**
     * Tatar
     * 
     */
    @XmlEnumValue("tat")
    TAT("tat"),

    /**
     * Telugu
     * 
     */
    @XmlEnumValue("tel")
    TEL("tel"),

    /**
     * Tajik
     * 
     */
    @XmlEnumValue("tgk")
    TGK("tgk"),

    /**
     * Tagalog
     * 
     */
    @XmlEnumValue("tgl")
    TGL("tgl"),

    /**
     * Thai
     * 
     */
    @XmlEnumValue("tha")
    THA("tha"),

    /**
     * Tigrinya
     * 
     */
    @XmlEnumValue("tir")
    TIR("tir"),

    /**
     * Tonga (Tonga Islands)
     * 
     */
    @XmlEnumValue("ton")
    TON("ton"),

    /**
     * Tswana
     * 
     */
    @XmlEnumValue("tsn")
    TSN("tsn"),

    /**
     * Tsonga
     * 
     */
    @XmlEnumValue("tso")
    TSO("tso"),

    /**
     * Turkmen
     * 
     */
    @XmlEnumValue("tuk")
    TUK("tuk"),

    /**
     * Turkish
     * 
     */
    @XmlEnumValue("tur")
    TUR("tur"),

    /**
     * Twi
     * 
     */
    @XmlEnumValue("twi")
    TWI("twi"),

    /**
     * Uighur, Uyghur
     * 
     */
    @XmlEnumValue("uig")
    UIG("uig"),

    /**
     * Ukrainian
     * 
     */
    @XmlEnumValue("ukr")
    UKR("ukr"),

    /**
     * Urdu
     * 
     */
    @XmlEnumValue("urd")
    URD("urd"),

    /**
     * Uzbek
     * 
     */
    @XmlEnumValue("uzb")
    UZB("uzb"),

    /**
     * Venda
     * 
     */
    @XmlEnumValue("ven")
    VEN("ven"),

    /**
     * Vietnamese
     * 
     */
    @XmlEnumValue("vie")
    VIE("vie"),

    /**
     * Volapuk
     * 
     */
    @XmlEnumValue("vol")
    VOL("vol"),

    /**
     * Walloon
     * 
     */
    @XmlEnumValue("wln")
    WLN("wln"),

    /**
     * Wolof
     * 
     */
    @XmlEnumValue("wol")
    WOL("wol"),

    /**
     * Xhosa
     * 
     */
    @XmlEnumValue("xho")
    XHO("xho"),

    /**
     * Yiddish
     * 
     */
    @XmlEnumValue("yid")
    YID("yid"),

    /**
     * Yoruba
     * 
     */
    @XmlEnumValue("yor")
    YOR("yor"),

    /**
     * Zhuang, Chuang
     * 
     */
    @XmlEnumValue("zha")
    ZHA("zha"),

    /**
     * Chinese
     * 
     */
    @XmlEnumValue("zho")
    ZHO("zho"),

    /**
     * Zulu
     * 
     */
    @XmlEnumValue("zul")
    ZUL("zul");
    private final String value;

    Languages(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Languages fromValue(String v) {
        for (Languages c: Languages.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
