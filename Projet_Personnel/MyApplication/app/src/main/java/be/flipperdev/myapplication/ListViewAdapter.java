package be.flipperdev.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

public class ListViewAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    List<Model> modelList;
    ArrayList<Model> arrayList;

    public ListViewAdapter(Context context, List<Model> modelList) {
        mContext = context;
        this.modelList = modelList;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modelList);
    }

    public class ViewHolder {
        TextView mTitleTV, mDescTV;

    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int i) {
        return modelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            holder.mTitleTV = view.findViewById(R.id.mainTitle);
            holder.mDescTV = view.findViewById(R.id.mainDesc);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.mTitleTV.setText(modelList.get(position).getTitle());
        holder.mDescTV.setText(modelList.get(position).getDesc());


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (modelList.get(position).getTitle().equals("Acétone")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Acétone");
                    intent.putExtra("contentTv", "L'acétone est l'un des corps cétoniques.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Acide aminé")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Acide aminé");
                    intent.putExtra("contentTv", "L'acide aminé est un constituant des protéines.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Acidocétose")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Acidocétose");
                    intent.putExtra("contentTv", "L'acidocétose est une acidification du sang par l’excès de corps cétoniques.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Albuminurie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Albuminurie");
                    intent.putExtra("contentTv", "L'albuminurie est la présence d’albumine dans les urines.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Albumine")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Albumine");
                    intent.putExtra("contentTv", "L'albumine est la  principale protéine du sang, soluble dans l’eau et fabriquée par le foie.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Amidon")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Amidon");
                    intent.putExtra("contentTv", "L'amidon est le polysaccharide présent dans les féculents.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Arthropathie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Arthropathie");
                    intent.putExtra("contentTv", "L'arthropathie est une pathologie articulaire.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Autocontrôle")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Autocontrôle");
                    intent.putExtra("contentTv", "L'autocontrôle est le contrôle par le patient lui-même de sa glycosurie et/ou de la glycémie.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Auto-immunité")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Auto-immunité");
                    intent.putExtra("contentTv", "L'auto-immunité est la réaction de l’organisme contre ses propres constituants.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Calorie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Calorie");
                    intent.putExtra("contentTv", "La calorie est la valeur énergétique d’un aliment (1 calorie = 4.2 joules).");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Capillaire")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Capillaire");
                    intent.putExtra("contentTv", "Le capillaire est un petit vaisseau sanguin.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Cellules bêta (ß)")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Cellules bêta (ß)");
                    intent.putExtra("contentTv", "Les cellules bêta (ß) sont des cellules des îlots de Langerhans qui sécrètent l’insuline.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Cétonurie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Cétonurie");
                    intent.putExtra("contentTv", "La cétonurie est la présence de corps cétoniques dans les urines.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Cétose")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Cétose");
                    intent.putExtra("contentTv", "La cétose est la formation d’un excès de corps cétoniques.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Corps cétoniques")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Corps cétoniques");
                    intent.putExtra("contentTv", "Les corps cétoniques sont les produits de la dégradation partielle des lipides responsables de la cétose.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Déshydratation")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Déshydratation");
                    intent.putExtra("contentTv", "La déshydratation est la conséquence d’une perte d’eau et de sel.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Diabète gestationnel")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Diabète gestationnel");
                    intent.putExtra("contentTv", "Le diabète gestationnel est un diabète « réversible » survenant durant la grossesse.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Diabète décompensé")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Diabète décompensé");
                    intent.putExtra("contentTv", "Le diabète décompensé est un diabète décompensé ou déséquilibré lorsque les valeurs glycémiques sont hors de contrôle de manière aiguë ou pendant des périodes prolongées.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Disaccharide")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Disaccharide");
                    intent.putExtra("contentTv", "Le disaccharide est un sucre composé de deux sucres simples, par exemple le saccharose.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Dyslipidémie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Dyslipidémie");
                    intent.putExtra("contentTv", "La dyslipidémie est une anomalies du taux des lipides (graisses) dans le sang.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Endocrine")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Endocrine");
                    intent.putExtra("contentTv", "L'endocrine sécrète des substances (hormones) déversées dans le sang.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Exocrine")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Exocrine");
                    intent.putExtra("contentTv", "L'exocrine sécrète des substances déversées dans une cavité en communication avec l’extérieur du corps (des enzymes ou des sucs digestifs par exemple).");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Exsudat")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Exsudat");
                    intent.putExtra("contentTv", "L'exsudat est un épanchement de liquide séreux dû à une modification de la perméabilité d’une membrane suite à une inflammation.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Fluoangiographie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Fluoangiographie");
                    intent.putExtra("contentTv", "La fluoangiographie est une technique utilisée par les ophtalmologues pour juger de l’état des petits vaisseaux du fond de l’oeil.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Fructose")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Fructose");
                    intent.putExtra("contentTv", "Le fructose est un sucre simple, présent principalement dans les fruits, le miel et le sucre (= saccharose).");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Glucagon")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Glucagon");
                    intent.putExtra("contentTv", "Le glucagon est une hormone sécrétée par les cellules des îlots de Langerhans et qui provoque une élévation de la glycémie.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Glucide")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Glucide");
                    intent.putExtra("contentTv", "Le glucide est un synonyme d’hydrate de carbone.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Glucose")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Glucose");
                    intent.putExtra("contentTv", "Le glucose est un sucre simple présent dans le sang.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Glycémie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Glycémie");
                    intent.putExtra("contentTv", "La glycémie est un taux de glucose dans le sang.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Glycogène")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Glycogène");
                    intent.putExtra("contentTv", "La glycogène est un polysaccharide de réserve présent dans le foie et les muscles.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Glycogénose")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Glycogénose");
                    intent.putExtra("contentTv", "La glycogénose est une maladie héréditaire due à l’absence d’une des enzymes intervenant dans le métabolisme du glycogène.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Glycosurie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Glycosurie");
                    intent.putExtra("contentTv", "La glycosurie est une présence de glucose dans les urines.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Groupes HLA")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Groupes HLA");
                    intent.putExtra("contentTv", "Les groupes HLA est une carte d’identité cellulaire, comparables aux groupes sanguins.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Hémoglobine")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Hémoglobine");
                    intent.putExtra("contentTv", "L'hémoglobine est un pigment rouge du sang qui transporte l’oxygène.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Hémoglobine glycosylée ou glycatée ou glyquée")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Hémoglobine glycosylée ou glycatée ou glyquée");
                    intent.putExtra("contentTv", "L'hémoglobine glycosylée ou glycatée ou glyquée est une partie de l’hémoglobine associée au glucose. Son dosage permet une estimation de l’équilibre moyen du diabète au cours des 2 mois précédents.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Hépatique")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Hépatique");
                    intent.putExtra("contentTv", "L'hépatique a un rapport au foie.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Hernie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Hernie");
                    intent.putExtra("contentTv", "L'hernie est un déplacement de tout ou d’une partie d’un organe hors de la cavité qui le contient normalement, par un passage naturel.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Hormone")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Hormone");
                    intent.putExtra("contentTv", "L'hormone est une substance sécrétée dans le sang par un organe particulier et qui exerce son action à distance sur d’autres organes.Hydrates de carbone : sucres en général.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Hyperglycémie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Hyperglycémie");
                    intent.putExtra("contentTv", "L'hyperglycémie est un taux excessif de glucose dans le sang.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Hyperglycémiant")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Hyperglycémiant");
                    intent.putExtra("contentTv", "L'hyperglycémiant fait monter le taux de sucre dans le sang.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Hypoglycémie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Hypoglycémie");
                    intent.putExtra("contentTv", "L'hypoglycémie est un taux insuffisant de glucose dans le sang.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Hypoglycémiant")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Hypoglycémiant");
                    intent.putExtra("contentTv", "L'hypoglycémiant est ce qui fait baisser le taux de sucre dans le sang.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Hypolipémiant")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Hypolipémiant");
                    intent.putExtra("contentTv", "L'hypolipémiant est ce qui fait baisser le taux des lipides (cholestérol, triglycérides) dans le sang.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Hypotension orthostatique")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Hypotension orthostatique");
                    intent.putExtra("contentTv", "L'hypotension orthostatique est une baisse de la tension sanguine en position debout.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Ilots de Langerhans")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Ilots de Langerhans");
                    intent.putExtra("contentTv", "L'ilots de Langerhans est un amas de cellules présents dans le pancréas.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Incrétines")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Incrétines");
                    intent.putExtra("contentTv", "Les incrétines sont des hormones gastrointestinales libérées au début du repas et stimulant la production d’insuline et inhibant le glucagon.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Index glycémique")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Index glycémique");
                    intent.putExtra("contentTv", "L'index glycémique est un pouvoir « sucrant » d’un aliment, c’est à dire effet de l’aliment sur la glycémie.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Injection sous-cutanée")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Injection sous-cutanée");
                    intent.putExtra("contentTv", "L'injection sous-cutanée est une injection sous la peau.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Insuline")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Insuline");
                    intent.putExtra("contentTv", "L'insuline est une hormone sécrétée par les cellules ß des îlots de Langerhans qui fait baisser la glycémie.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Intolérance glucidique")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Intolérance glucidique");
                    intent.putExtra("contentTv", "L'intolérance glucidique est une forme de prédiabète, intermédiaire entre la situation normale et le diabète.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Joule")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Joule");
                    intent.putExtra("contentTv", "Joule est une unité de mesure énergétique des aliments.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Lipides")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Lipides");
                    intent.putExtra("contentTv", "Les lipides sont des graisses en général.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Macroangiopathie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Macroangiopathie");
                    intent.putExtra("contentTv", "La macroangiopathie est une complication touchant les gros vaisseaux sanguins (artériosclérose ou athérosclérose).");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Mal perforant plantaire")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Mal perforant plantaire");
                    intent.putExtra("contentTv", "Le mal perforant plantaire est une complication touchant essentiellement la plante des pieds.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Microalbuminurie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Microalbuminurie");
                    intent.putExtra("contentTv", "Une microalbuminurie est une présence de petites quantités d’albumine dans les urines.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Microanévrisme")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Microanévrisme");
                    intent.putExtra("contentTv", "Un microanévrisme est une dilatation des capillaires du fond de l’oeil.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Microangiopathie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Microangiopathie");
                    intent.putExtra("contentTv", "Une microangiopathie est une complication touchant les petits vaisseaux sanguins.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Miction")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Miction");
                    intent.putExtra("contentTv", "Miction est l'action d’uriner.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Monosaccharide")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Monosaccharide");
                    intent.putExtra("contentTv", "Le monosaccharide est un sucre simple comme le glucose ou le fructose.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Myocarde")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Myocarde");
                    intent.putExtra("contentTv", "Un myocarde est un muscle cardiaque.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Néphropathie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Néphropathie");
                    intent.putExtra("contentTv", "Un néphropathie est une complication touchant les reins.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Neuropathie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Neuropathie");
                    intent.putExtra("contentTv", "Une neuropathie est une complication touchant les nerfs.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Pancréas")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Pancréas");
                    intent.putExtra("contentTv", "Le pancréas est un organe allongé se trouvant derrière l’estomac qui comporte une partie exocrine (enzymes digestifs) et une partie endocrine (insuline, glucagon).");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Plasma")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Plasma");
                    intent.putExtra("contentTv", "Le plasma est une partie liquide du sang par rapport aux éléments figurés (globules).");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Polynévrite")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Polynévrite");
                    intent.putExtra("contentTv", "Une polynévrite est une atteinte des nerfs.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Polysaccharide")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Polysaccharide");
                    intent.putExtra("contentTv", "Le polysaccharide est un sucre complexe, composé de nombreuses molécules de glucose.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Polyurie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Polyurie");
                    intent.putExtra("contentTv", "La polyurie sont des urines abondantes.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Postprandial")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Postprandial");
                    intent.putExtra("contentTv", "Le postprandial est le moment qui suit le repas.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Prédiabète")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Prédiabète");
                    intent.putExtra("contentTv", "Le prédiabète est une période plus ou moins longue d’hyperglycémie modérée sans symptôme, qui précède l’apparition du diabète.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Préprandial")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Préprandial");
                    intent.putExtra("contentTv", "Le préprandial est un moment qui précède le repas.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Profil glycémique")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Profil glycémique");
                    intent.putExtra("contentTv", "Le profil glycémique est une mesure de la glycémie plusieurs fois par jour, avant (et parfois aussi deux heures après) les principaux repas.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Protéines")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Protéines");
                    intent.putExtra("contentTv", "Les protéines sont des constituants principaux des muscles et de la plupart des organes du corps.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Oedème maculaire")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Oedème maculaire");
                    intent.putExtra("contentTv", "L'oedème maculaire est un \"gonflement\" de la macula, la partie centrale de la rétine responsable de l’acuité de la vision, faisant suite à une augmentation de la perméabilité vasculaire et à une fuite de protéines à ce niveau.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Ostéite")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Ostéite");
                    intent.putExtra("contentTv", "L'ostéite est une infection de l’os.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Rétine")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Rétine");
                    intent.putExtra("contentTv", "La rétine est une membrane se trouvant au fond de l’oeil sur laquelle se forment les images.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Rétinopathie")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Rétinopathie");
                    intent.putExtra("contentTv", "Une rétinopathie est une complication oculaire touchant la rétine.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Saccharose")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Saccharose");
                    intent.putExtra("contentTv", "Le saccharose est un sucre composé de glucose et de fructose ; c’est le sucre de ménage le plus utilisé.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Statines")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Statines");
                    intent.putExtra("contentTv", "Les statines sont des hypolipémiants utilisés comme médicaments pour baisser le taux de cholestérol.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Tension artérielle systolique")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Tension artérielle systolique");
                    intent.putExtra("contentTv", "La tension artérielle systolique correspond à la pression qui règne dans les vaisseaux au moment où le coeur se contracte.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Tension artérielle diastolique")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Tension artérielle diastolique");
                    intent.putExtra("contentTv", "La tension artérielle diastolique correspond à la pression qui règne dans les vaisseaux entre deux contractions cardiaque.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Triglycérides")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Triglycérides");
                    intent.putExtra("contentTv", "Les triglycérides est une variété de graisses.");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Trouble cognitif")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Trouble cognitif");
                    intent.putExtra("contentTv", "Un trouble cognitif est un trouble de la fonction cérébrale cognitive (intellectuelle).");
                    mContext.startActivity(intent);
                }
                if (modelList.get(position).getTitle().equals("Critères de diagnostic sur base d'une prise de sang réalisée à jeun")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Critères de diagnostic sur base d'une prise de sang réalisée à jeun");
                    intent.putExtra("contentTv", "À l'heure actuelle 1) une glycémie normale à jeun se situe entre 70 et 110 mg/dl 2) entre 100 mg/dl et 125 mg/dl à jeun, on parle d'intolérance glucidique ou de \"prédiabète\" 3) si la glycémie égale ou dépasse les 126 mg/dl à jeun ou 200 mg/dl à n'importe quel moment.");
                    mContext.startActivity(intent);
                }

            }
        });

        return view;
    }


    public void filter(String charTex) {
        charTex = charTex.toLowerCase(Locale.getDefault());
        modelList.clear();
        if (charTex.length() == 0) {
            modelList.addAll(arrayList);
        } else {
            for (Model model : arrayList) {
                if (model.getTitle().toLowerCase(Locale.getDefault()).contains(charTex)) {
                    modelList.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}
