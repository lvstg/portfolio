package be.flipperdev.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;
    String[] title;
    String[] description;
    ArrayList<Model> arrayList = new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("DicoAbète");

        title = new String[]{"Acétone", "Acide aminé", "Acidocétose", "Albuminurie", "Albumine",
                "Amidon", "Arthropathie", "Autocontrôle", "Auto-immunité", "Calorie", "Capillaire",
                "Cellules bêta (ß)", "Cétonurie", "Cétose", "Corps cétoniques", "Déshydratation",
                "Diabète gestationnel", "Diabète décompensé", "Disaccharide", "Dyslipidémie", "Endocrine",
                "Exocrine", "Exsudat", "Fluoangiographie", "Fructose", "Glucagon", "Glucide", "Glucose",
                "Glycémie", "Glycogène", "Glycogénose", "Glycosurie", "Groupes HLA", "Hémoglobine",
                "Hémoglobine glycosylée ou glycatée ou glyquée", "Hépatique", "Hernie", "Hormone",
                "Hyperglycémie", "Hyperglycémiant", "Hypoglycémie", "Hypoglycémiant", "Hypolipémiant",
                "Hypotension orthostatique", "Ilots de Langerhans", "Incrétines", "Index glycémique",
                "Injection sous-cutanée", "Insuline", "Intolérance glucidique", "Joule", "Lipides",
                "Macroangiopathie", "Mal perforant plantaire", "Microalbuminurie", "Microanévrisme",
                "Microangiopathie", "Miction", "Monosaccharide", "Myocarde", "Néphropathie", "Neuropathie",
                "Pancréas", "Plasma", "Polynévrite", "Polysaccharide", "Polyurie", "Postprandial",
                "Prédiabète", "Préprandial", "Profil glycémique", "Protéines", "Oedème maculaire",
                "Ostéite", "Rétine", "Rétinopathie", "Saccharose", "Statines", "Tension artérielle systolique",
                "Tension artérielle diastolique", "Triglycérides", "Trouble cognitif",
                "Critères de diagnostic sur base d'une prise de sang réalisée à jeun"
        };

        description = new String[]{"L'acétone est l'un des corps cétoniques.",
                "L'acide aminé est un constituant des protéines.",
                "L'acidocétose est une acidification du sang par l’excès de corps cétoniques.",
                "L'albuminurie est la présence d’albumine dans les urines.",
                "L'albumine est la  principale protéine du sang, soluble dans l’eau et fabriquée par le foie.",
                "L'amidon est le polysaccharide présent dans les féculents.", "L'arthropathie est une pathologie articulaire.",
                "L'autocontrôle est le contrôle par le patient lui-même de sa glycosurie et/ou de la glycémie.",
                "L'auto-immunité est la réaction de l’organisme contre ses propres constituants.",
                "La calorie est la valeur énergétique d’un aliment (1 calorie = 4.2 joules).",
                "Le capillaire est un petit vaisseau sanguin.", "Les cellules bêta (ß) sont des cellules des îlots de Langerhans qui sécrètent l’insuline.",
                "La cétonurie est la présence de corps cétoniques dans les urines.",
                "La cétose est la formation d’un excès de corps cétoniques.",
                "Les corps cétoniques sont les produits de la dégradation partielle des lipides responsables de la cétose.",
                "La déshydratation est la conséquence d’une perte d’eau et de sel.",
                "Le diabète gestationnel est un diabète « réversible » survenant durant la grossesse.",
                "Le diabète décompensé est un diabète décompensé ou déséquilibré lorsque les valeurs glycémiques sont hors de contrôle de manière aiguë ou pendant des périodes prolongées.",
                "Le disaccharide est un sucre composé de deux sucres simples, par exemple le saccharose.",
                "La dyslipidémie est une anomalies du taux des lipides (graisses) dans le sang.",
                "L'endocrine sécrète des substances (hormones) déversées dans le sang.",
                "L'exocrine sécrète des substances déversées dans une cavité en communication avec l’extérieur du corps (des enzymes ou des sucs digestifs par exemple).",
                "L'exsudat est un épanchement de liquide séreux dû à une modification de la perméabilité d’une membrane suite à une inflammation.",
                "La fluoangiographie est une technique utilisée par les ophtalmologues pour juger de l’état des petits vaisseaux du fond de l’oeil.",
                "Le fructose est un sucre simple, présent principalement dans les fruits, le miel et le sucre (= saccharose).",
                "Le glucagon est une hormone sécrétée par les cellules des îlots de Langerhans et qui provoque une élévation de la glycémie.",
                "Le glucide est un synonyme d’hydrate de carbone.",
                "Le glucose est un sucre simple présent dans le sang.",
                "La glycémie est un taux de glucose dans le sang.",
                "La glycogène est un polysaccharide de réserve présent dans le foie et les muscles.",
                "La glycogénose est une maladie héréditaire due à l’absence d’une des enzymes intervenant dans le métabolisme du glycogène.",
                "La glycosurie est une présence de glucose dans les urines.",
                "Les groupes HLA est une carte d’identité cellulaire, comparables aux groupes sanguins.",
                "L'hémoglobine est un pigment rouge du sang qui transporte l’oxygène.",
                "L'hémoglobine glycosylée ou glycatée ou glyquée est une partie de l’hémoglobine associée au glucose. Son dosage permet une estimation de l’équilibre moyen du diabète au cours des 2 mois précédents.",
                "L'hépatique a un rapport au foie.",
                "L'hernie est un déplacement de tout ou d’une partie d’un organe hors de la cavité qui le contient normalement, par un passage naturel.",
                "L'hormone est une substance sécrétée dans le sang par un organe particulier et qui exerce son action à distance sur d’autres organes.Hydrates de carbone : sucres en général.",
                "L'hyperglycémie est un taux excessif de glucose dans le sang.",
                "L'hyperglycémiant fait monter le taux de sucre dans le sang.",
                "L'hypoglycémie est un taux insuffisant de glucose dans le sang.",
                "L'hypoglycémiant est ce qui fait baisser le taux de sucre dans le sang.",
                "L'hypolipémiant est ce qui fait baisser le taux des lipides (cholestérol, triglycérides) dans le sang.",
                "L'hypotension orthostatique est une baisse de la tension sanguine en position debout.",
                "L'ilots de Langerhans est un amas de cellules présents dans le pancréas.",
                "Les incrétines sont des hormones gastrointestinales libérées au début du repas et stimulant la production d’insuline et inhibant le glucagon.",
                "L'index glycémique est un pouvoir « sucrant » d’un aliment, c’est à dire effet de l’aliment sur la glycémie.",
                "L'injection sous-cutanée est une injection sous la peau.",
                "L'insuline est une hormone sécrétée par les cellules ß des îlots de Langerhans qui fait baisser la glycémie.",
                "L'intolérance glucidique est une forme de prédiabète, intermédiaire entre la situation normale et le diabète.",
                "Joule est une unité de mesure énergétique des aliments.",
                "Les lipides sont des graisses en général.",
                "La macroangiopathie est une complication touchant les gros vaisseaux sanguins (artériosclérose ou athérosclérose).",
                "Le mal perforant plantaire est une complication touchant essentiellement la plante des pieds.",
                "Une microalbuminurie est une présence de petites quantités d’albumine dans les urines.",
                "Un microanévrisme est une dilatation des capillaires du fond de l’oeil.",
                "Une microangiopathie est une complication touchant les petits vaisseaux sanguins.",
                "Miction est l'action d’uriner.",
                "Le monosaccharide est un sucre simple comme le glucose ou le fructose.",
                "Un myocarde est un muscle cardiaque.",
                "Un néphropathie est une complication touchant les reins.",
                "Une neuropathie est une complication touchant les nerfs.",
                "Le pancréas est un organe allongé se trouvant derrière l’estomac qui comporte une partie exocrine (enzymes digestifs) et une partie endocrine (insuline, glucagon).",
                "Le plasma est une partie liquide du sang par rapport aux éléments figurés (globules).",
                "Une polynévrite est une atteinte des nerfs.",
                "Le polysaccharide est un sucre complexe, composé de nombreuses molécules de glucose.",
                "La polyurie sont des urines abondantes.",
                "Le postprandial est le moment qui suit le repas.",
                "Le prédiabète est une période plus ou moins longue d’hyperglycémie modérée sans symptôme, qui précède l’apparition du diabète.",
                "Le préprandial est un moment qui précède le repas.",
                "Le profil glycémique est une mesure de la glycémie plusieurs fois par jour, avant (et parfois aussi deux heures après) les principaux repas.",
                "Les protéines sont des constituants principaux des muscles et de la plupart des organes du corps.",
                "L'oedème maculaire est un \"gonflement\" de la macula, la partie centrale de la rétine responsable de l’acuité de la vision, faisant suite à une augmentation de la perméabilité vasculaire et à une fuite de protéines à ce niveau.",
                "L'ostéite est une infection de l’os.",
                "La rétine est une membrane se trouvant au fond de l’oeil sur laquelle se forment les images.",
                "Une rétinopathie est une complication oculaire touchant la rétine.",
                "Le saccharose est un sucre composé de glucose et de fructose ; c’est le sucre de ménage le plus utilisé.",
                "Les statines sont des hypolipémiants utilisés comme médicaments pour baisser le taux de cholestérol.",
                "La tension artérielle systolique correspond à la pression qui règne dans les vaisseaux au moment où le coeur se contracte.",
                "La tension artérielle diastolique correspond à la pression qui règne dans les vaisseaux entre deux contractions cardiaque.",
                "Les triglycérides est une variété de graisses.",
                "Un trouble cognitif est un trouble de la fonction cérébrale cognitive (intellectuelle).",
                "À l'heure actuelle, les critères de diagnostic sur base d'une prise de sang réalisée à jeun sont : 1) une glycémie normale à jeun se situe entre 70 et 110 mg/dl 2) entre 100 mg/dl et 125 mg/dl à jeun, on parle d'intolérance glucidique ou de \"prédiabète\" 3) si la glycémie égale ou dépasse les 126 mg/dl à jeun ou 200 mg/dl à n'importe quel moment, on pose un diagnostic de diabète."

        };

        listView = findViewById(R.id.listView);

        for (int i = 0; i < title.length; i++) {
            Model model = new Model(title[i], description[i]);

            arrayList.add(model);
        }

        adapter = new ListViewAdapter(this, arrayList);

        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);


        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)) {
                    adapter.filter("");
                    listView.clearTextFilter();
                } else {
                    adapter.filter(s);
                }
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}