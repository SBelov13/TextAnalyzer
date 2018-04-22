/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mai.textanalyzer.tester;

import com.mai.textanalyzer.classifier.common.TextClassifier;
import com.mai.textanalyzer.classifier.weka_classifier.WekaClassifier;
import com.mai.textanalyzer.classifier.common.ClassifierEnum;
import com.mai.textanalyzer.creater.Creater;
import com.mai.textanalyzer.dao.classifier.IPropertysClassifierDao;
import com.mai.textanalyzer.indexing.common.Indexer;
import com.mai.textanalyzer.indexing.common.IndexerEnum;
import static com.mai.textanalyzer.indexing.common.IndexerEnum.DOC2VEC;
import com.mai.textanalyzer.word_processing.RusUTF8FileLabelAwareIterator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.text.documentiterator.LabelledDocument;
import org.deeplearning4j.text.documentiterator.LabelsSource;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static com.mai.textanalyzer.creater.Creater.loadClassifier;
import static com.mai.textanalyzer.creater.Creater.createAndSaveClassifier;
import com.mai.textanalyzer.creater.SaveModelException;

/**
 *
 * @author Sergey
 */
public class Tester {

    private static final Logger log = Logger.getLogger(Tester.class);

    public static void main(String[] args) {
//        List<File> testingRootFolders = new ArrayList<>();
//        testingRootFolders.add(new File("E:\\DataForClassifier\\RootFolderSize200"));
//        testingRootFolders.add(new File("E:\\DataForClassifier\\RootFolderSize6582"));
//        testingRootFolders.add(new File("E:\\DataForClassifier\\RootFolderSize13711"));

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
//        IPropertysClassifierDao classifierDao = ctx.getBean(IPropertysClassifierDao.class);
//        System.out.println(classifierDao.getInfo());
        File rootFolder = new File("E:\\DataForClassifier\\RootFolderSize200");
//        TextClassifier classifier = loadClassifier(rootFolder, ClassifierEnum.NAIVE_BAYES, DOC2VEC);
//        Indexer indexer = Creater.loadIndexer(DOC2VEC, rootFolder);

        createModel(rootFolder, IndexerEnum.DOC2VEC, ClassifierEnum.IBK);
        testModel(rootFolder, IndexerEnum.DOC2VEC, ClassifierEnum.IBK);

//        System.out.println(Arrays.toString(wc.getDistribution(indexer.getIndex("ОглавлениеВведение Небольшой экскурс в развитии теории гравитацииО природе гравитационных силОсобенности гравитационного взаимодействияЗаключениеСписок литературыПриложение\n"
//                + "ВведениеОдна из аксиом современной науки гласит: любые материальные объекты во Вселенной связаны между собой силами всемирного тяготения. Благодаря этим силам формируются и существуют небесные тела – планеты, звезды, галактики и Метагалактика в целом. Форма и структура этих тел и материальных систем, а также относительное движение и взаимодействие определяются динамическим равновесием между силами их тяготения и силами инерции масс.В течение всей своей жизни человек ощущает силу тяжести своего тела и предметов, которые ему приходится поднимать. Однако еще на полтора века раньше до Ньютона и Гука знаменитый польский ученый Николай Коперник писал о тяготении: «Тяжесть есть не что иное, как естественное стремление, которым отец Вселенной одарил все частицы, а именно соединяться в одно общее целое, образуя тела шаровидной формы». Аналогичные мысли высказывали и другие ученые. Найденные Ньютоном и Гуком формулы закона тяготения позволили с большой точностью рассчитать орбиты планет и создать первую математическую модель Вселенной. Вопрос о том, существует ли окружающий нас мир сам по себе или он является продуктом деятельности разума (принадлежащего некому высшему существу или каждому конкретному индивиду) составляет суть основного вопроса философии, классически формулируемом в виде дилеммы о первичности материи или сознания. Окружающие нас объекты природы имеют внутреннюю структуру, т.е. в свою очередь сами состоят из других объектов, (яблоко состоит из клеток растительной ткани, которая сложена из молекул, являющихся объединениями атомов и т.д.). При этом естественным образом возникают различные по сложности уровни организации материи: космический, планетарный, геологический, биологический, химический, физический.Влияет или нет распределение всей материи во Вселенной на протекание физических процессов? Существует или нет какая-либо связь между гравитационным взаимодействием и принципом неопределённости? Конечно, в современной физике существуют и другие вопросы, на которые пока нет ответа.Гравитация есть взаимодействие посредством обмена импульсами между разнонаправлено движущимися материальными системами.Особенности гравитационного взаимодействия можно понять, изучая динамику наиболее удобной гравитирующей системы, – планеты Земля, основываясь на единстве законов, действующих в любой области физической реальности. Но необходимо изучать динамику Земли как двухполюсной активной (живой) системы, а не монолитной, пусть и слоисто-симметричной, абстрактной математической модели. Такая полярность сил тяготения обусловлена следующими факторами.Универсальностью сил тяготения в природе. В физической реальности не существует иных взаимодействий, кроме гравитационных.Еще в 1936–1937 годах возможность такого распределения плотности была получена Булленом, но расценена как неприемлемая.Однозначным несоответствием прогнозируемых максимальных давлений в центре Земли существующему минимуму силы тяжести – единственной причине (согласно классической физике) возникновения высоких давлений.Показателями разуплотнения внутренних оболочек могут служить избыток реального экваториального вздутия планеты (70 м) и несоответствие нормальных градиентов силы тяжести, соотносимых с разностью экваториального и полярного радиусов.До настоящего времени не зафиксированы поперечные сейсмические волны, прошедшие сквозь внутреннее ядро.Достаточно известные геофизикам оценки физического состояния вещества ядра по расчетам момента инерции пустотелой и сплошной моделей планеты, и сравнение его с данными анализа динамики системы «Земля – Луна» выполнены некорректно.Хорошо известно, что основная масса Солнечной системы (около 99.8%) приходится на ее единственную звезду – Солнце. Суммарная масса планет составляет только 0.13% от общей. На остальные тела системы (кометы, спутники планет, астероиды и метеоритное вещество) приходится только 0.0003% массы. Из приведенных цифр следует, что законы Кеплера для движения планет в нашей системе должны выполняться очень хорошо.Весьма привлекательная теория совместного происхождения солнца и планет из единого газового облака, сжавшегося под действием гравитационных сил, оказывается в противоречии с наблюдаемым неравномерным распределением вращательного момента (момента импульса) между звездой и планетами.Обсуждаются модели происхождения планет в результате гравитационного захвата Солнцем тел, прилетающих из далекого космоса, эффекты, вызванные взрывом сверхновых. В большинстве «сценариев» развития солнечной системы существование пояса астероидов, так или иначе, связывается с его близким соседством с самой массивной планетой системы.\n"
//                + "1. Небольшой экскурс в развитии теории гравитацииПервоначально считалось, что Земля неподвижна, а движение небесных тел казалось весьма сложным. Галилей одним из первых высказал предположение о том, что наша планета не является исключением и тоже движется вокруг Солнца. Эта концепция была встречена достаточно враждебно. Тихо Браге решил не принимать участия в дискуссиях, а заняться непосредственными измерениями координат тел на небесной сфере. Позднее данные Тихо попали к Кеплеру, который нашел простое объяснение наблюдаемым сложным траекториям, сформулировав три законов движения планет (и Земли) вокруг Солнца:1. Планеты двигаются по эллиптическим орбитам, в одном из фокусов которых находится Солнце.2. Скорость движения планеты изменяется таким образом, что площади, заметаемые ее радиус-вектором за равные промежутки времени, оказываются равными.3. Периоды обращения планет одной Солнечной системы и большие полуоси их орбит связаны соотношением:Сложное движение планет на «небесной сфере», наблюдаемой с Земли, согласно Кеплеру, возникало вследствие сложения этих планет по эллиптическим орбитам с движением наблюдателя, совершающего вместе с Землей орбитальное движение вокруг солнца и суточное вращение вокруг оси планеты.Прямым доказательством суточного вращения Земли был эксперимент, поставленный Фуко, в котором плоскость колебаний маятника поворачивалась относительно поверхности вращающейся Земли.Законы Кеплера прекрасно описывали наблюдаемое движение планет, но не вскрывали причин, приводящих к такому движению (напр. вполне можно было считать, что причиной движения тел по Кеплеровым орбитам являлась воля какого-либо существа или стремление самих небесных тел к гармонии). Теория гравитации Ньютона указала причину, обусловившую движение космических тел по законам Кеплера, правильно предсказала и объяснила особенности их движения в более сложных случаях, позволила в одних терминах описать многие явления космического и земного масштабов (движение звезд в галактическом скоплении и падение яблока на поверхность Земли).Ньютон нашел правильное выражение для гравитационной силы, возникающей при взаимодействии двух точечных тел (тел, размеры которых малы по сравнению с расстоянием между ними), которое совместно со вторым законом в случае, если масса планеты много меньше массы звезды, приводило к дифференциальному уравнению, допускающему аналитическое решение. Не привлекая каких-либо дополнительных физических идей, чисто математическими методами можно показать, что при соответствующих начальных условиях достаточно малые начальные расстояние до звезды и скорость планеты) космическое тело будет совершать вращение по замкнутой, устойчивой эллиптической орбите в полном согласии с законами Кеплера (в частности второй закон Кеплера является прямым следствием закона сохранения момента импульса, выполняющегося при гравитационных взаимодействиях, поскольку момент силы относительно массивного центра всегда равен нулю). При достаточно высокой начальной скорости (ее значение зависит от массы звезды и начального положения) космическое тело движется по гиперболической траектории, в конце концов, уходя от звезды на бесконечно большое расстояние.Важным свойством закона гравитации является сохранение его математической формы в случае гравитационного взаимодействия неточечных тел в случае сферически-симметричного распределения их масс по объему. При этом роль играет расстояние между центрами этих тел.\n"
//                + "2. О природе гравитационных силСформулированный Ньютоном закон всемирного тяготения относится к фундаментальным законам классического естествознания. Методологической слабостью концепции Ньютона был его отказ обсуждать механизмы, приводящие к возникновению гравитационных сил («Я гипотез не измышляю»). После Ньютона неоднократно предпринимались попытки создания теории гравитации.Подавляющее большинство подходов связано с так называемыми гидродинамическими моделями гравитации, пытающимися объяснить возникновение сил тяготения механическими взаимодействиями массивных тел с промежуточной субстанцией, которой приписывается то или иное название: «эфир», «поток гравитонов», «вакуум» и т.д. Притяжение между телами возникает вследствие разряжения Среды, возникающей либо при ее поглощении массивными телами, либо при экранировке ими ее потоков. Все эти теории имеют общий существенный недостаток: правильно предсказывая зависимость силы от расстояния, они неизбежно приводят к еще одному ненаблюдаемому эффекту: торможению тел, движущихся относительно введенной субстанции.Существенно новый шаг в развитии концепции гравитационного взаимодействия был сделан А. Эйнштейном, создавшим общую теорию относительности.Ньютон: «Тяготение к Солнцу составляется из тяготения к отдельным частицам его и при удалении от Солнца убывает в точности пропорционально квадратам расстояний даже до орбиты Сатурна, что следует из покоя афелиев планет и даже до крайних афелиев комет, если только эти афелии находятся в покое» [6, с. 662]. Эта особенность гравитационного взаимодействия, приложенная к условиям внутри тела и приводит к убывающей зависимости гравитационной силы с уменьшением расстояния от центра тела.Вторая проблема гравитационного поля, связанная со стабильностью взаимного положения небесных тел, тоже постепенно решалась, и в частности, большой шаг в направлении её решения был сделан с одной стороны Эддингтоном [7], а с другой стороны Френкелем [8, гл. 7], предположившими с различными вариациями возможность обобществления электронов атомов в ядрах звёзд при гравитационном сжатии. Более полно данная концепция с учётом особенностей гравитационного сжатия протозвёздного облака, описанного Шкловским (9). Причём данная концепция очень хорошо согласуется с поступающими новыми данными о небесных телах, как солнечной системы, так и дальних небесных объектов и главное, полностью снимает проблему неограниченного сжатия вещества вселенной. Ведь с учётом формирования электронного кокона звезды и ассоциации звёзд взаимное гравитационное притяжение удалённых горячих небесных тел эффективно компенсируется взаимным отталкиванием электронных оболочек этих тел, препятствуя, с одной стороны, неограниченному сжатию всего вещества вселенной, а с другой стороны препятствуя столкновению между звёздами и их ассоциациями, как и каннибализму галактик. Тем самым снимается проблема, которую видел в своей концепции ещё Ньютон.Сформулированный Ньютоном закон всемирного тяготения стал одним из выдающихся достижений в области естествознания за всю историю его существования. Этот закон позволил на строгой научной основе подвести физическую базу под философско-космическими положениями о материальном единстве мира, всеобщей взаимосвязи всех природных явлений. Закон всемирного тяготения оказался одним из самых впечатляющих и вместе с тем загадочных основоположений теоретического естествознания. Применение этого закона позволило добиться выдающихся успехов в области небесной механики (предсказавшей «на кончике пера» существование ранее неизвестных планет) и астрофизики, космологии и практического освоения космического пространства, позволило летательным аппаратам и человеку преодолеть земное притяжение и осуществить прорыв в просторы Вселенной.3. Особенности гравитационного взаимодействияОсобенность гравитационного взаимодействия состоит в том, что под действием силы гравитационной природы прироста полной энергии пробного тела не происходит (т.е. полная энергия свободно падающего (и не излучающего!) пробного тела не меняется, оставаясь равной полной начальной энергии; перераспределяется лишь соотношение между его энергетическими компонентами). Если в самом начале движения полная энергия пробного тела соответствовала его массе покоя, то по мере разгона все большая её часть соответствует уже кинетической составляющей массы, которая появляется за счет уменьшения массы покоя. В этой особенности гравитационного действия заключены истоки принципиального различия между силами гравитации и инерции. Свойство инерции проявляет себя при непосредственном взаимодействии тел между собой, в результате чего любое тело, в зависимости от особенности взаимодействия и выбора системы отсчета наблюдателем, может, как получить дополнительную кинетическую энергию, либо утратить имеющуюся, передав её другим телам. Силы гравитационной природы способны перераспределять энергию из одного вида в другой в пределах данного тела: энергию покоя, внутреннюю энергию, поперечную кинетическую составляющую энергии – в продольную кинетическую энергетическую составляющую. В соответствии с перераспределением составляющих энергии изменяется импульс тела. Величина, оказываясь продуктом действия гравитационного поля, увеличивает инерцию тела в направлении падения, но сама уже не подвержена влиянию гравитационного поля. Поле само по себе не в состоянии различить, является ли продуктом его действия, или результатом действия силы иной природы. Поэтому, независимо от происхождения, вполне резонно предположение, что на эту составляющую гравитационное поле влияния не оказывает. При ощутимой относительной доле продольной кинетической составляющей величина ускорения g будет отставать от напряженности гравитационного поля g. Сила, действующая на вертикально падающее тело в g-поле, пропорциональна его массе покоя и составляет m0g.Энергия, переносимая фотоном, определяется исключительно его кинетической энергией. Она может быть передана при непосредственном взаимодействии, что указывает на наличие у фотона инертных свойств и соответственно инертной массы. Гравитационная масса фотона не является постоянной величиной. В случае вертикально ориентированного свободного фотона (движение фотона параллельно вектору напряженности g-поля) g-поле на фотон не действует: гравитационная масса фотона равна нулю; массы покоя фотон также не имеет. Отсюда наблюдаемое «посинение» или «покраснение» фотона имеет своей причиной различный ход времени в системах «верхнего» и «нижнего» наблюдателей.В связи с высказанными выше соображениями не будет излишним проявлять осторожность в выражении соответствия между массой объекта и полной его энергией. Не всякой энергетической составляющей соответствует гравитационная масса; возможно также, что в определенных случаях инертные свойства могут не соответствовать в точности их энергетическому потенциалу. Гравитационная масса объекта по отношению к любому другому гравитирующему объекту определяется сугубо индивидуальноПостоянство движения определяется существованием единой фундаментальной константы гравитационной постоянной, или постоянной действия (взаимодействия). По величине оно должна быть равна кванту действия (постоянной Планка). Значение последней было подобрано для максимального соответствия расчетных и экспериментальных данных.Неуничтожаемость и постоянство движения должно означать постоянство передачи импульса при гравитационном взаимодействии.Это означает, что гравитирующая (движущаяся) система должна за единицу времени передать одинаковую энергию движения определенному количеству систем в соответствии с законом сохранения импульса.Гравитационное взаимодействие обладает определёнными характерными чертами, которые делают его непохожим на другие взаимодействия (например, на электромагнитное).Наиболее важные особенности гравитации.Во-первых, ускорение тела в гравитационном поле не зависит от его массы. Поэтому все тела движутся в гравитационном поле с одинаковым ускорением. С одной стороны, ускорение тела пропорционально действующей на него силе и, следовательно, пропорционально его гравитационной массе. Но с другой стороны, ускорение тела обратно пропорционально его инертной массе. Таким образом, как пишет Ричард Фейнман в своих лекциях по гравитации, «первый изумительный факт, связанный с гравитацией, заключается в том, что отношение инерциальной и гравитационной массы постоянно, где бы мы его не проверяли» [10; с. 62].«Второй изумительный факт, связанный с гравитацией, заключается в том, что это взаимодействие очень слабое» [10; с. 62].Существенной особенностью гравитации является и её универсальный характер – всё, что существует в природе, участвует в гравитационном взаимодействии. Кроме того, гравитация – это всегда только притяжение, а гравитационного отталкивания просто не существует.И, наконец, можно отметить следующее. Законы, управляющие нашим миром, в самой своей основе – это законы квантовой механики. Иначе говоря, в фундаменте всех физических взаимодействий лежит принцип неопределённости.Но ни закон тяготения Ньютона, ни его модификация, сделанная Эйнштейном в общей теории относительности, совершенно не учитывают этот фундаментальный принцип.\n"
//                + "ЗаключениеМасштабы космического пространства и времени (точнее – Пространства-Времени) не могут не завораживать и не вдохновлять. Еще больше завораживают ее тайны – открытые и неоткрытые. Последних, конечно, неизмеримо больше. И по мере развития наших знаний о Вселенной, практического освоения Космоса и реального проникновения человека сначала в ближайшие окрестности Солнечной системы, а затем и за ее пределы – будут появляться все новые и новые тайны, требующие новых усилий в их разгадке и, следовательно, новых книг. В общем случае гравитационная масса (гравитационный заряд) тела не равна его инертной массе. Гравитационной массой определяется взаимодействие тела с g-полем, а инертной массой – способность транспортировать энергию в пространстве. Стационарное g-поле не способно изменить ни полную массу, ни полную энергию свободно падающего тела. В гравитационном поле лишь перераспределяются энергетические составляющие полной энергии тела, характеризующие его исходное состояние и меняется импульс тела.Фотон есть первооснова вещества, обладающего инертными свойствами (постулат о единстве состава материи на уровне первомассы). Таким образом, наша планета Земля – активная динамическая система, субсферический тороид.В любой движущейся и взаимодействующей (гравитирующей) системе суммарный импульс взаимодействующего вещества равен суммарному импульсу порождаемого этим веществом излучения.\n"
//                + "Список литературыАзимов А. Вселенная. М., 1969;Анисимов А.Ф. Космические представления народов Севера. \n"
//                + "М. – Л., 1959;Берри А. Краткая история астрономии. М. – Л., 1946;Вайнберг С. Первые три минуты: Современный взгляд на происхождение Вселенной. М., 1981;Ван-дер-Варден Б. Пробуждающаяся наука. Рождение астрономии. М., 1991;Засов А.В., Кононович Э.В. Астрономия: Атлас для общеобразовательных учреждений. М., 1996;Звездочет (журнал). 1995–1997;Земля и Вселенная (журнал). 1980–1997;Знание – сила (журнал). 1960–1997;Мизнер Ч., Торн К., Уилер Дж. Гравитация. В 3-х томах. Бишкек, 1994;Нарликар Дж. Гравитация без формул. М., 1985;Наука и жизнь (журнал). 1960–1997;Струве О., Линдс Б., Пилланс Э. Элементарная астрономия. М., 1964;Шкловский И.С. Вселенная, жизнь, разум. М., 1962;\n"
//                + "ПриложениеПостулаты1. АБСОЛЮТНОСТЬАбсолютная субстанция – вечное постоянное движение (динамика) материальных систем (МС) различного ранга.2. ОТНОСИТЕЛЬНОСТЬИзучение движения (эволюции) МС процесс относительный. Для этого нужны нематериальные (не взаимодействующие с материей) инструменты – ПРОСТРАНСТВО и ВРЕМЯ.3. ЕДИНСТВО ДЕЙСТВУЮЩИХ ЗАКОНОВЗаконы, регламентирующие взаимодействие МС, едины в любой области физической реальности. («Природа проста и не роскошествует излишними причинами вещей», И. Ньютон).Законы эволюции МС– переход количества в качество;– одновременное действие двух полярных субстанций, что означает единство противоположностей.ЗАКОН СОХРАНЕНИЯ ЭНЕРГИИ ДВИЖЕНИЯДвижение-взаимодействие вещества системы осуществляется при соблюдении закона сохранения суммарного импульса. Количество движения, сообщенное телу, должно быть передано объектам, с которыми взаимодействует движущееся тело.ОТСУТСТВИЕ В ПРИРОДЕ МОНОСИСТЕМЛюбая МС представляет набор систем более высокого ранга (локальных), динамически организованных в соответствии с суммарным количеством вещества.  "))));
        //        testingRootFolders.forEach((rootFolder) -> {
//            createModel(rootFolder, IndexerEnum.DOC2VEC, ClassifierEnum.NAIVE_BAYES);
//            testModel(rootFolder, IndexerEnum.DOC2VEC, ClassifierEnum.NAIVE_BAYES);
//            createModel(rootFolder, IndexerEnum.TF_IDF, ClassifierEnum.NAIVE_BAYES);
//            testModel(rootFolder, IndexerEnum.TF_IDF, ClassifierEnum.NAIVE_BAYES);
//        });
    }

    private static void createModel(File rootFolder, IndexerEnum indexerEnum, ClassifierEnum classifierEnum) {
        OutputStream os = null;
        try {
            log.info("Start create " + indexerEnum);
            os = new FileOutputStream(new File(Creater.getSaveModelFolder(rootFolder), "Create" + ClassifierEnum.getFullNameModel(classifierEnum, indexerEnum) + "Log.txt"));
            Long curTime = System.currentTimeMillis();
            String info;
            try {
                Creater.createAndSaveIndexer(indexerEnum, rootFolder);
                info = "Create time for " + indexerEnum + ": " + ((double) (System.currentTimeMillis() - curTime) / 1000) + " c.\n";
            } catch (SaveModelException ignore) {
                info = "Сохраненая модель " + indexerEnum + " уже существует\n";
            }
            log.info(info);
            os.write(info.getBytes(), 0, info.length());
            curTime = System.currentTimeMillis();
            log.info("Start create " + classifierEnum);
            try {
                Creater.createAndSaveClassifier(rootFolder, classifierEnum, indexerEnum);
                info = "Create time for " + classifierEnum + ": " + ((double) (System.currentTimeMillis() - curTime) / 1000) + " c.";
            } catch (SaveModelException ignore) {
                info = "Сохраненая модель " + classifierEnum + " уже существует\n";
            }
            log.info(info);
            os.write(info.getBytes(), 0, info.length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testModel(File rootFolder, IndexerEnum indexerEnum, ClassifierEnum classifierEnum) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File(Creater.getSaveModelFolder(rootFolder), ClassifierEnum.getFullNameModel(classifierEnum, indexerEnum) + "Log.txt"));
            String info = "Test " + ClassifierEnum.getFullNameModel(classifierEnum, indexerEnum);
            log.info(info);
            os.write(info.getBytes(), 0, info.length());
            Indexer indexer = Creater.loadIndexer(indexerEnum, rootFolder);
            info = "DimensionSize: " + indexer.getDimensionSize();
            log.info(info);
            os.write(info.getBytes(), 0, info.length());
            TextClassifier wc = Creater.loadClassifier(rootFolder, classifierEnum, indexerEnum);
            RusUTF8FileLabelAwareIterator tearchingIteratorTest = new RusUTF8FileLabelAwareIterator.Builder()
                    .addSourceFolder(Creater.getDocForTestFolder(rootFolder))
                    .build();
            LabelsSource labelsSource = tearchingIteratorTest.getLabelsSource();
            int size = tearchingIteratorTest.getSize();
            Evaluation eval = new Evaluation(labelsSource.size());
            int count = 0;
            while (tearchingIteratorTest.hasNext()) {
                LabelledDocument next = tearchingIteratorTest.next();
                INDArray matrixTextModel = indexer.getIndex(next.getContent());
                String predict = wc.classifyMessage(matrixTextModel);
                String topic = next.getLabel();
                count++;
                System.out.println(count + "/" + size + ": " + topic + " - " + predict);
                eval.eval(labelsSource.indexOf(predict), labelsSource.indexOf(topic));
            }
            info = eval.stats(true) + "\n";
            log.info(info);
            os.write(info.getBytes(), 0, info.length());
            for (String label : labelsSource.getLabels()) {
                info = label + ": " + eval.f1(labelsSource.indexOf(label)) + "\n";
                log.info(info);
                os.write(info.getBytes(), 0, info.length());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
